import java.util.Scanner;

public class StringSplitCompare {

    // Method to find length without using length()
    public static int getStringLengthWithoutLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // end of string reached
        }
        return count;
    }

    // Method to split string into words using charAt() without split()
    public static String[] splitWithoutSplit(String text) {
        int length = getStringLengthWithoutLength(text);

        // Count words by counting spaces + 1 (considering leading/trailing spaces ignored)
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

        // Create array to store words
        String[] words = new String[wordCount];
        int start = 0;

        for (int i = 0; i < wordCount; i++) {
            int end = (i == wordCount - 1) ? length : spaceIndexes[i];

            // Extract characters from start to end-1 for the word
            StringBuilder word = new StringBuilder();
            for (int j = start; j < end; j++) {
                word.append(text.charAt(j));
            }
            words[i] = word.toString();

            start = end + 1; // move start to next character after space
        }
        return words;
    }

    // Method to compare two String arrays
    public static boolean compareStringArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) return false;

        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input
        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();

        // User-defined split
        String[] userSplit = splitWithoutSplit(input);

        // Built-in split
        String[] builtInSplit = input.split(" ");

        // Display words from user-defined method
        System.out.println("\nWords from user-defined split:");
        for (String w : userSplit) {
            System.out.println(w);
        }

        // Display words from built-in split
        System.out.println("\nWords from built-in split:");
        for (String w : builtInSplit) {
            System.out.println(w);
        }

        // Compare arrays
        boolean areEqual = compareStringArrays(userSplit, builtInSplit);

        System.out.println("\nAre both splits equal? " + (areEqual ? "✅ Yes" : "❌ No"));

        scanner.close();
    }
}
