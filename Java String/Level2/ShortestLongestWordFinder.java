import java.util.Scanner;

public class ShortestLongestWordFinder {

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

        // Count words by counting spaces + 1 (consider multiple spaces too)
        int wordCount = 0;
        boolean inWord = false;

        for (int i = 0; i < length; i++) {
            if (text.charAt(i) != ' ' && !inWord) {
                wordCount++;
                inWord = true;
            } else if (text.charAt(i) == ' ') {
                inWord = false;
            }
        }

        String[] words = new String[wordCount];
        int wordIndex = 0;
        int start = -1;
        inWord = false;

        for (int i = 0; i <= length; i++) {
            if (i < length && text.charAt(i) != ' ' && !inWord) {
                start = i;
                inWord = true;
            } else if ((i == length || text.charAt(i) == ' ') && inWord) {
                // Extract word
                StringBuilder word = new StringBuilder();
                for (int j = start; j < i; j++) {
                    word.append(text.charAt(j));
                }
                words[wordIndex++] = word.toString();
                inWord = false;
            }
        }
        return words;
    }

    // Method to create a 2D array with word and length as string
    public static String[][] wordsWithLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            int len = getStringLengthWithoutLength(words[i]);
            result[i][1] = String.valueOf(len);
        }
        return result;
    }

    // Method to find shortest and longest word from 2D array
    // Returns String array of size 2: [shortestWord, longestWord]
    public static String[] findShortestLongest(String[][] wordLengths) {
        if (wordLengths.length == 0) {
            return new String[] {"", ""};
        }

        String shortest = wordLengths[0][0];
        int shortestLen = Integer.parseInt(wordLengths[0][1]);

        String longest = wordLengths[0][0];
        int longestLen = Integer.parseInt(wordLengths[0][1]);

        for (int i = 1; i < wordLengths.length; i++) {
            int len = Integer.parseInt(wordLengths[i][1]);
            if (len < shortestLen) {
                shortestLen = len;
                shortest = wordLengths[i][0];
            }
            if (len > longestLen) {
                longestLen = len;
                longest = wordLengths[i][0];
            }
        }
        return new String[] {shortest, longest};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();

        String[] words = splitWithoutSplit(input);
        String[][] wordsAndLengths = wordsWithLengths(words);
        String[] shortestLongest = findShortestLongest(wordsAndLengths);

        System.out.println("\nWords and their lengths:");
        System.out.printf("%-15s | %s\n", "Word", "Length");
        System.out.println("--------------------------");
        for (String[] wl : wordsAndLengths) {
            System.out.printf("%-15s | %s\n", wl[0], wl[1]);
        }

        System.out.println("\nShortest word: " + shortestLongest[0]);
        System.out.println("Longest word: " + shortestLongest[1]);

        scanner.close();
    }
}
