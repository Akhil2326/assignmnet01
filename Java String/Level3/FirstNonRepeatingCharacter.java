import java.util.Scanner;

public class FirstNonRepeatingCharacter {

    // Method to find the length of a string without using length()
    public static int getStringLength(String text) {
        int length = 0;
        try {
            while (true) {
                text.charAt(length);
                length++;
            }
        } catch (IndexOutOfBoundsException e) {
            // Reached end of string
        }
        return length;
    }

    // Method to find the first non-repeating character using charAt()
    public static char findFirstNonRepeatingCharacter(String text) {
        int length = getStringLength(text);
        int[] frequency = new int[256]; // Array to store frequency of characters

        // Count the frequency of each character
        for (int i = 0; i < length; i++) {
            char currentChar = text.charAt(i);
            frequency[currentChar]++;
        }

        // Find the first non-repeating character
        for (int i = 0; i < length; i++) {
            if (frequency[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }

        return '\0'; // Return null character if no non-repeating character is found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String inputText = scanner.nextLine();

        char result = findFirstNonRepeatingCharacter(inputText);
        if (result != '\0') {
            System.out.println("The first non-repeating character is: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }

        scanner.close();
    }
}
