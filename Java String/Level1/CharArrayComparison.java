import java.util.Scanner;

public class CharArrayComparison {

    // Method to extract characters from a string without using toCharArray()
    public static char[] getCharsUsingCharAt(String text) {
        int length = text.length();
        char[] result = new char[length];
        
        for (int i = 0; i < length; i++) {
            result[i] = text.charAt(i);
        }
        
        return result;
    }

    // Method to compare two character arrays
    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        
        return true;
    }

    // Method to print a character array
    public static void printCharArray(String label, char[] arr) {
        System.out.print(label + ": ");
        for (char c : arr) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter a string: ");
        String input = scanner.next();

        // Get character arrays
        char[] customCharArray = getCharsUsingCharAt(input);
        char[] builtinCharArray = input.toCharArray();

        // Print both arrays
        printCharArray("User-defined char array", customCharArray);
        printCharArray("Built-in toCharArray()", builtinCharArray);

        // Compare and print result
        boolean areEqual = compareCharArrays(customCharArray, builtinCharArray);

        System.out.println("\nAre both character arrays equal? " + (areEqual ? "✅ Yes" : "❌ No"));

        scanner.close();
    }
}
