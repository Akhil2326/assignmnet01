import java.util.Scanner;

public class SubstringComparison {

    // Method to create substring using charAt()
    public static String createSubstringUsingCharAt(String text, int start, int end) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i < end; i++) {
            result.append(text.charAt(i));
        }
        return result.toString();
    }

    // Method to compare two strings using charAt()
    public static boolean compareUsingCharAt(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter the original string: ");
        String inputText = scanner.next();

        System.out.print("Enter the start index: ");
        int startIndex = scanner.nextInt();

        System.out.print("Enter the end index: ");
        int endIndex = scanner.nextInt();

        // Validate indices
        if (startIndex < 0 || endIndex > inputText.length() || startIndex >= endIndex) {
            System.out.println("❌ Invalid indices. Make sure 0 <= start < end <= length of string.");
            return;
        }

        // Substring using charAt()
        String manualSubstring = createSubstringUsingCharAt(inputText, startIndex, endIndex);

        // Substring using built-in substring()
        String builtinSubstring = inputText.substring(startIndex, endIndex);

        // Compare both substrings
        boolean areEqual = compareUsingCharAt(manualSubstring, builtinSubstring);

        // Display results
        System.out.println("\n🔹 Substring using charAt(): " + manualSubstring);
        System.out.println("🔹 Substring using substring(): " + builtinSubstring);

        if (areEqual) {
            System.out.println("✅ Both substrings are equal.");
        } else {
            System.out.println("❌ Substrings are NOT equal.");
        }

        scanner.close();
    }
}
