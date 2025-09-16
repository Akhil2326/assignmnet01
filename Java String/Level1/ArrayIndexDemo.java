import java.util.Scanner;

public class ArrayIndexDemo {

    // Sample array of names
    static String[] names = {"Alice", "Bob", "Charlie", "Daisy", "Ethan"};

    // Method to generate ArrayIndexOutOfBoundsException (no handling)
    public static void generateException(int index) {
        System.out.println("Accessing index " + index + ": " + names[index]);  // May throw exception
    }

    // Method to handle ArrayIndexOutOfBoundsException using try-catch
    public static void handleException(int index) {
        try {
            System.out.println("Accessing index " + index + ": " + names[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("❌ Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("❌ Caught RuntimeException: " + e.getMessage());
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display available names
        System.out.println("Available names:");
        for (int i = 0; i < names.length; i++) {
            System.out.println("Index " + i + ": " + names[i]);
        }

        // Take index input from the user
        System.out.print("\nEnter an index to access: ");
        int index = scanner.nextInt();

        // Step 1: Generate exception (unhandled in method)
        System.out.println("\n----- Generating ArrayIndexOutOfBoundsException -----");
        try {
            generateException(index);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught in main: " + e.getMessage());
        }

        // Step 2: Handle exception gracefully
        System.out.println("\n----- Handling ArrayIndexOutOfBoundsException -----");
        handleException(index);

        scanner.close();
    }
}
