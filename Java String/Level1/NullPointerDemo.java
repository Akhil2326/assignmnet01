public class NullPointerDemo {

    // Method to generate NullPointerException
    public static void generateException() {
        String text = null;

        // This will throw NullPointerException
        System.out.println("Length of text: " + text.length());
    }

    // Method to handle NullPointerException using try-catch
    public static void handleException() {
        String text = null;

        try {
            System.out.println("Length of text: " + text.length());
        } catch (NullPointerException e) {
            System.out.println("❌ Caught NullPointerException: " + e.getMessage());
        }
    }

    // Main method
    public static void main(String[] args) {
        // Step 1: Generate the exception (this will crash the program)
        System.out.println("----- Generating NullPointerException -----");
        try {
            generateException();
        } catch (NullPointerException e) {
            System.out.println("Caught Exception in main: " + e.getMessage());
        }

        // Step 2: Handling the exception gracefully
        System.out.println("\n----- Handling NullPointerException -----");
        handleException();
    }
}
