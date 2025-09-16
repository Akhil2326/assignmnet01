import java.util.Scanner;

public class PalindromeChecker {

    // Logic 1: Iterative method to check palindrome
    public static boolean isPalindromeIterative(String text) {
        int start = 0;
        int end = text.length() - 1;
        
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Logic 2: Recursive method to check palindrome
    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    // Logic 3: Using character arrays to check palindrome
    // Helper method to reverse the string using charAt()
    public static char[] reverseString(String text) {
        int len = text.length();
        char[] reversed = new char[len];
        for (int i = 0; i < len; i++) {
            reversed[i] = text.charAt(len - 1 - i);
        }
        return reversed;
    }

    // Check palindrome by comparing original and reversed char arrays
    public static boolean isPalindromeCharArray(String text) {
        char[] original = text.toCharArray();
        char[] reversed = reverseString(text);

        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the text to check palindrome: ");
        String text = sc.nextLine();

        // Logic 1
        boolean resultIterative = isPalindromeIterative(text);
        System.out.println("Iterative check: " + (resultIterative ? "Palindrome" : "Not Palindrome"));

        // Logic 2
        boolean resultRecursive = isPalindromeRecursive(text, 0, text.length() - 1);
        System.out.println("Recursive check: " + (resultRecursive ? "Palindrome" : "Not Palindrome"));

        // Logic 3
        boolean resultCharArray = isPalindromeCharArray(text);
        System.out.println("Char Array check: " + (resultCharArray ? "Palindrome" : "Not Palindrome"));

        sc.close();
    }
}
