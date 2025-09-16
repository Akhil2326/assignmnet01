import java.util.Scanner;

public class LowerCaseConverter {

    // Method to manually convert to lowercase using ASCII logic
    public static String convertToLowerManual(String text) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // If uppercase (A-Z), convert to lowercase
            if (ch >= 'A' && ch <= 'Z') {
                result.append((char)(ch + 32)); // Convert to lowercase
            } else {
                result.append(ch); // Leave other characters unchanged
            }
        }

        return result.toString();
    }

    // Method to compare two strings character-by-character using charAt()
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

        // Take user input
        System.out.print("Enter a line of text: ");
        String input = scanner.nextLine();

        // Manual lowercase conversion
        String manualLower = convertToLowerManual(input);

        // Built-in lowercase conversion
        String builtInLower = input.toLowerCase();

        // Compare both results
        boolean isSame = compareStrings(manualLower, builtInLower);

        // Output results
        System.out.println("\nManual Lowercase Conversion:   " + manualLower);
        System.out.println("Built-in Lowercase Conversion: " + builtInLower);
        System.out.println("\nAre both conversions the same? " + (isSame ? "✅ Yes" : "❌ No"));

        scanner.close();
    }
}
