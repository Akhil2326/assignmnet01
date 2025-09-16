import java.util.Scanner;

public class StringComparison {

    // Method to compare two strings using charAt()
    public static boolean compareUsingCharAt(String str1, String str2) {
        // Check if lengths are different
        if (str1.length() != str2.length()) {
            return false;
        }

        // Compare characters one by one
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter first string: ");
        String firstString = scanner.next();

        System.out.print("Enter second string: ");
        String secondString = scanner.next();

        // Comparing using charAt
        boolean charAtResult = compareUsingCharAt(firstString, secondString);

        // Comparing using built-in equals method
        boolean equalsResult = firstString.equals(secondString);

        // Displaying results
        System.out.println("\nComparison using charAt(): " + charAtResult);
        System.out.println("Comparison using equals(): " + equalsResult);

        // Check if both methods give the same result
        if (charAtResult == equalsResult) {
            System.out.println("✅ Both methods give the SAME result.");
        } else {
            System.out.println("❌ Methods give DIFFERENT results.");
        }

        scanner.close();
    }
}
