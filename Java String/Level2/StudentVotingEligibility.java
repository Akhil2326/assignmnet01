import java.util.Random;
import java.util.Scanner;

public class StudentVotingEligibility {

    // Method to generate random 2-digit ages for n students
    public static int[] generateRandomAges(int n) {
        Random random = new Random();
        int[] ages = new int[n];
        for (int i = 0; i < n; i++) {
            // Generate age between 10 and 99 (2-digit)
            ages[i] = 10 + random.nextInt(90); 
        }
        return ages;
    }

    // Method to check voting eligibility and return 2D array with age and "true"/"false"
    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] results = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {
            results[i][0] = String.valueOf(ages[i]);
            if (ages[i] < 0) {
                // Negative age invalid - cannot vote
                results[i][1] = "false";
            } else if (ages[i] >= 18) {
                results[i][1] = "true";
            } else {
                results[i][1] = "false";
            }
        }
        return results;
    }

    // Method to display the 2D array in tabular format
    public static void displayResults(String[][] data) {
        System.out.printf("%-10s | %-15s%n", "Age", "Can Vote");
        System.out.println("-------------------------");
        for (String[] row : data) {
            System.out.printf("%-10s | %-15s%n", row[0], row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input for number of students (10 by problem statement)
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();

        // Generate random ages for n students
        int[] ages = generateRandomAges(n);

        // Check voting eligibility
        String[][] votingData = checkVotingEligibility(ages);

        // Display the results
        System.out.println("\nStudent Voting Eligibility:");
        displayResults(votingData);

        scanner.close();
    }
}
