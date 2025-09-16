import java.util.Scanner;

public class StringIndexDemo {

    // Method to generate StringIndexOutOfBoundsException (unhandled)
    public static void generateException(String text) {
        // Trying to access an index beyond string length
        System.out.println("Character at index 100: " + text.charAt(100));
    }

    // Method to handle StringIndexOutOfBoundsException using try-catch
    public static void handleException(String text) {
        try {
            System.out.println("Character at index 100: " + text.charAt(100));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("❌ Caught StringIndexOutOfBoundsException: " + e.getMessage());
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a string: ");
        String userInput = scanner.next();

        // Step 1: Generate the exception (unhandled)
        System.out.println("\n----- Generating StringIndexOutOfBoundsException -----");
        try {
            generateException(userInput);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught Exception in main: " + e.getMessage());
        }

        // Step 2: Handle the exception gracefully
        System.out.println("\n----- Handling StringIndexOutOfBoundsException -----");
        handleException(userInput);

        scanner.close();
    }
}
