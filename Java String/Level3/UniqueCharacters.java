import java.util.Scanner;

public class UniqueCharacters {

    // Method to find the length of a string without using length()
    public static int stringLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            // Reached end of string
        }
        return count;
    }

    // Method to find unique characters in a string using charAt()
    public static char[] findUniqueCharacters(String text) {
        int length = stringLength(text);
        char[] tempUnique = new char[length];
        int uniqueCount = 0;

        for (int i = 0; i < length; i++) {
            char currentChar = text.charAt(i);
            boolean isUnique = true;

            // Check if currentChar has appeared before in tempUnique array
            for (int j = 0; j < uniqueCount; j++) {
                if (tempUnique[j] == currentChar) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                tempUnique[uniqueCount] = currentChar;
                uniqueCount++;
            }
        }

        // Copy unique chars to a new array of size uniqueCount
        char[] uniqueChars = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            uniqueChars[i] = tempUnique[i];
        }

        return uniqueChars;
    }

    // Main method to take input and display unique characters
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String inputText = sc.nextLine();

        char[] uniqueChars = findUniqueCharacters(inputText);

        System.out.print("Unique characters in the string are: ");
        for (char c : uniqueChars) {
            System.out.print(c + " ");
        }
        System.out.println();

        sc.close();
    }
}
