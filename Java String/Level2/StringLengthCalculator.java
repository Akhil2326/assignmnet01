import java.util.Scanner;

public class StringLengthCalculator {

    // Method to find length without using length() method
    public static int getStringLengthWithoutLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);  // Will throw exception when index is out of bounds
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // End of string reached
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter a word: ");
        String input = scanner.next();

        // Custom method
        int calculatedLength = getStringLengthWithoutLength(input);

        // Built-in method
        int builtInLength = input.length();

        // Display results
        System.out.println("\nLength using custom method:  " + calculatedLength);
        System.out.println("Length using length() method: " + builtInLength);
        System.out.println("\nAre both lengths equal? " + (calculatedLength == builtInLength ? "✅ Yes" : "❌ No"));

        scanner.close();
    }
}
