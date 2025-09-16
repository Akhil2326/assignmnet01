import java.util.Scanner;

public class UniqueCharFrequency {
    
    // Method to find unique characters in a string
    public static char[] uniqueCharacters(String text) {
        int length = getStringLength(text);
        char[] tempUnique = new char[length];
        int uniqueCount = 0;
        
        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == ch) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                tempUnique[uniqueCount++] = ch;
            }
        }
        
        // Copy unique chars to exact size array
        char[] uniqueChars = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            uniqueChars[i] = tempUnique[i];
        }
        return uniqueChars;
    }

    // Method to get length of string without using length()
    public static int getStringLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            // reached end of string
        }
        return count;
    }
    
    // Method to find frequency of characters using unique characters
    public static String[][] frequencyUsingUnique(String text) {
        int length = getStringLength(text);
        int[] frequency = new int[256];
        
        // Count frequency of all characters
        for (int i = 0; i < length; i++) {
            frequency[text.charAt(i)]++;
        }
        
        // Get unique characters
        char[] uniqueChars = uniqueCharacters(text);
        
        // Create 2D array to store character and frequency as String
        String[][] result = new String[uniqueChars.length][2];
        for (int i = 0; i < uniqueChars.length; i++) {
            result[i][0] = String.valueOf(uniqueChars[i]);
            result[i][1] = String.valueOf(frequency[uniqueChars[i]]);
        }
        
        return result;
    }

    // Method to display the frequency table
    public static void displayFrequency(String[][] data) {
        System.out.printf("%-10s %-10s\n", "Character", "Frequency");
        System.out.println("-------------------------");
        for (String[] entry : data) {
            System.out.printf("%-10s %-10s\n", entry[0], entry[1]);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();
        
        String[][] freqData = frequencyUsingUnique(text);
        displayFrequency(freqData);
        sc.close();
    }
}
