import java.util.Scanner;

public class VowelConsonantChecker {

    // Method to check the type of character and return "Vowel", "Consonant", or "Not a Letter"
    public static String checkCharType(char ch) {
        // Convert uppercase to lowercase using ASCII difference if needed
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char)(ch + 32);
        }

        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }

        return "Not a Letter";
    }

    // Method to create 2D array of characters and their types
    public static String[][] analyzeString(String text) {
        int length = text.length();
        String[][] result = new String[length][2];

        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);
            result[i][0] = String.valueOf(ch);
            result[i][1] = checkCharType(ch);
        }
        return result;
    }

    // Method to display the 2D array in tabular format
    public static void displayTable(String[][] arr) {
        System.out.printf("%-10s | %-12s%n", "Character", "Type");
        System.out.println("---------------------------");
        for (String[] row : arr) {
            System.out.printf("%-10s | %-12s%n", row[0], row[1]);
        }
    }

    // Main method to take input and display result
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a text: ");
        String input = scanner.nextLine();

        String[][] analyzedResult = analyzeString(input);

        displayTable(analyzedResult);

        scanner.close();
    }
}
