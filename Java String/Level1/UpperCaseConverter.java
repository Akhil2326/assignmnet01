import java.util.Scanner;

public class UpperCaseConverter {

    // Method to convert string to uppercase manually using charAt()
    public static String convertToUpperManual(String text) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            // If lowercase (a-z), convert to uppercase using ASCII
            if (ch >= 'a' && ch <= 'z') {
                result.append((char)(ch - 32));
            } else {
                result.append(ch); // Leave other characters unchanged
            }
        }
        return result.toString();
    }

    // Method to compare two strings character by character using charAt()
    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) return false;
        }
        return true;
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take full line of input
        System.out.print("Enter a line of text: ");
        String input = scanner.nextLine();

        // Convert using manual method
        String manualUpper = convertToUpperManual(input);

        // Convert using built-in method
        String builtInUpper = input.toUpperCase();

        // Compare both strings
        boolean isSame = compareStrings(manualUpper, builtInUpper);

        // Display the results
        System.out.println("\nManual Uppercase Conversion: " + manualUpper);
        System.out.println("Built-in Uppercase Conversion: " + builtInUpper);

        System.out.println("\nAre both conversions same? " + (isSame ? "✅ Yes" : "❌ No"));

        scanner.close();
    }
}
