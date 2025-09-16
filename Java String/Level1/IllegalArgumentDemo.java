import java.util.Scanner;

public class IllegalArgumentDemo {

    // Method to generate IllegalArgumentException (without handling)
    public static void generateException(String text) {
        // Intentionally setting start > end to trigger the exception
        System.out.println("Trying to get substring from index 5 to 2:");
        String result = text.substring(5, 2); // This throws IllegalArgumentException
        System.out.println("Substring: " + result);
    }

    // Method to handle IllegalArgumentException using try-catch
    public static void handleException(String text) {
        try {
            System.out.println("Trying to get substring from index 5 to 2:");
            String result = text.substring(5, 2); // Same logic, but handled
            System.out.println("Substring: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Caught IllegalArgumentException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("❌ Caught RuntimeException: " + e.getMessage());
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a string: ");
        String input = scanner.next();

        // Step 1: Generate exception (unhandled first)
        System.out.println("\n----- Generating IllegalArgumentException -----");
        try {
            generateException(input);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught Exception in main: " + e.getMessage());
        }

        // Step 2: Handle exception using try-catch
        System.out.println("\n----- Handling IllegalArgumentException -----");
        handleException(input);

        scanner.close();
    }
}
