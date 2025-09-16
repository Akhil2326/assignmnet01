import java.util.Scanner;

public class NumberFormatDemo {

    // Method to generate NumberFormatException without handling
    public static void generateException(String text) {
        // Attempt to convert non-numeric string to an integer
        System.out.println("Trying to convert to number: " + text);
        int number = Integer.parseInt(text); // This will throw NumberFormatException if text is not a valid number
        System.out.println("Parsed number: " + number);
    }

    // Method to handle NumberFormatException using try-catch
    public static void handleException(String text) {
        try {
            System.out.println("Trying to convert to number: " + text);
            int number = Integer.parseInt(text);
            System.out.println("Parsed number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("❌ Caught NumberFormatException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("❌ Caught RuntimeException: " + e.getMessage());
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter a number (or text): ");
        String input = scanner.next();

        // Step 1: Generate exception (unhandled inside method)
        System.out.println("\n----- Generating NumberFormatException -----");
        try {
            generateException(input);
        } catch (NumberFormatException e) {
            System.out.println("Caught Exception in main: " + e.getMessage());
        }

        // Step 2: Handle exception using try-catch
        System.out.println("\n----- Handling NumberFormatException -----");
        handleException(input);

        scanner.close();
    }
}
