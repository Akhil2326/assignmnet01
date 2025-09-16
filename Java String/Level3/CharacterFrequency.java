import java.util.Scanner;

public class CharacterFrequency {

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

    // Method to find the frequency of each character using charAt()
    public static String[][] findCharacterFrequencies(String text) {
        int length = getStringLength(text);
        int[] frequency = new int[256]; // Array to store frequency of characters

        // Count the frequency of each character
        for (int i = 0; i < length; i++) {
            char currentChar = text.charAt(i);
            frequency[currentChar]++;
        }

        // Create a 2D array to store characters and their frequencies
        int uniqueCount = 0;
        for (int i = 0; i < 256; i++) {
            if (frequency[i] > 0) {
                uniqueCount++;
            }
        }

        String[][] result = new String[uniqueCount][2];
        int index = 0;
        for (int i = 0; i < 256; i++) {
            if (frequency[i] > 0) {
                result[index][0] = String.valueOf((char) i);
                result[index][1] = String.valueOf(frequency[i]);
                index++;
            }
        }

        return result;
    }

    // Method to display the character frequencies in tabular format
    public static void displayFrequencies(String[][] data) {
        System.out.printf("%-10s %-10s\n", "Character", "Frequency");
        System.out.println("-------------------------");
        for (String[] entry : data) {
            System.out.printf("%-10s %-10s\n", entry[0], entry[1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String inputText = sc.nextLine();

        String[][] frequencies = findCharacterFrequencies(inputText);
        displayFrequencies(frequencies);

        sc.close();
    }
}
