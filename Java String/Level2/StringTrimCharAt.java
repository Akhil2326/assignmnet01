import java.util.Scanner;

public class StringTrimCharAt {

    // Method to find start and end index after trimming leading and trailing spaces
    public static int[] trimIndices(String text) {
        int start = 0;
        int end = text.length() - 1;

        // Find first non-space from the start
        while (start <= end && text.charAt(start) == ' ') {
            start++;
        }
        // Find first non-space from the end
        while (end >= start && text.charAt(end) == ' ') {
            end--;
        }
        return new int[] {start, end};
    }

    // Method to create substring from charAt() with given start and end indices (inclusive)
    public static String substringUsingCharAt(String text, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            sb.append(text.charAt(i));
        }
        return sb.toString();
    }

    // Method to compare two strings using charAt()
    public static boolean compareStringsCharAt(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a text with leading and trailing spaces: ");
        String input = scanner.nextLine();

        // Trim using charAt() method
        int[] indices = trimIndices(input);
        String trimmedByCharAt = "";
        if (indices[0] <= indices[1]) {  // Check to avoid empty or all spaces string
            trimmedByCharAt = substringUsingCharAt(input, indices[0], indices[1]);
        }

        // Trim using built-in method
        String trimmedBuiltIn = input.trim();

        // Compare the two trimmed strings
        boolean areEqual = compareStringsCharAt(trimmedByCharAt, trimmedBuiltIn);

        // Display results
        System.out.println("Trimmed using charAt(): \"" + trimmedByCharAt + "\"");
        System.out.println("Trimmed using built-in trim(): \"" + trimmedBuiltIn + "\"");
        System.out.println("Are both trimmed strings equal? " + areEqual);

        scanner.close();
    }
}
