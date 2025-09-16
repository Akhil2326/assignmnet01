import java.util.Scanner;

public class WordLengthTable {

    // Method to find string length without using length()
    public static int getStringLengthWithoutLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // End of string reached
        }
        return count;
    }

    // Method to split string into words without using split()
    public static String[] splitWithoutSplit(String text) {
        int length = getStringLengthWithoutLength(text);

        // Count words by counting spaces + 1
        int wordCount = 1;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }

        // Store indexes of spaces
        int[] spaceIndexes = new int[wordCount - 1];
        int idx = 0;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[idx++] = i;
            }
        }

        // Extract words using space indexes
        String[] words = new String[wordCount];
        int start = 0;

        for (int i = 0; i < wordCount; i++) {
            int end = (i == wordCount - 1) ? length : spaceIndexes[i];
            StringBuilder word = new StringBuilder();
            for (int j = start; j < end; j++) {
                word.append(text.charAt(j));
            }
            words[i] = word.toString();
            start = end + 1;
        }

        return words;
    }

    // Method to convert words to 2D array [word, length as string]
    public static String[][] wordsWithLengths(String[] words) {
        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            int length = getStringLengthWithoutLength(words[i]);
            result[i][1] = String.valueOf(length);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input sentence
        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();

        // Split into words
        String[] words = splitWithoutSplit(input);

        // Get 2D array with words and their lengths
        String[][] wordsAndLengths = wordsWithLengths(words);

        // Display result in tabular format
        System.out.printf("%-15s | %-6s\n", "Word", "Length");
        System.out.println("------------------------");
        for (String[] row : wordsAndLengths) {
            // Convert length back to int for display
            int len = Integer.parseInt(row[1]);
            System.out.printf("%-15s | %-6d\n", row[0], len);
        }

        scanner.close();
    }
}
