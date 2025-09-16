import java.util.Scanner;

public class CharFrequencyNestedLoop {
    
    // Method to find frequency of characters using nested loops
    public static String[] frequencyUsingNestedLoops(String text) {
        char[] chars = text.toCharArray();
        int length = chars.length;
        int[] freq = new int[length];
        
        // Initialize frequencies to 1
        for (int i = 0; i < length; i++) {
            freq[i] = 1;
        }
        
        // Nested loops to count frequency and mark duplicates as '0'
        for (int i = 0; i < length; i++) {
            if (chars[i] == '0') continue;  // skip duplicates
            for (int j = i + 1; j < length; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0'; // mark duplicate
                }
            }
        }
        
        // Count unique characters (chars[i] != '0')
        int uniqueCount = 0;
        for (int i = 0; i < length; i++) {
            if (chars[i] != '0') uniqueCount++;
        }
        
        // Create 1D array to store character and frequency as string (e.g. "a: 3")
        String[] result = new String[uniqueCount];
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (chars[i] != '0') {
                result[index++] = chars[i] + ": " + freq[i];
            }
        }
        
        return result;
    }
    
    // Method to display the frequency results
    public static void displayFrequency(String[] freqData) {
        System.out.println("Character Frequency");
        System.out.println("-------------------");
        for (String entry : freqData) {
            System.out.println(entry);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();
        
        String[] freqData = frequencyUsingNestedLoops(text);
        displayFrequency(freqData);
        sc.close();
    }
}
