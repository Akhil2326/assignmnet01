import java.util.Random;

public class StudentScorecard {

    // Method to generate random PCM scores for n students (returns 2D array: [n][3])
    public static int[][] generateScores(int n) {
        Random rand = new Random();
        int[][] scores = new int[n][3]; // physics, chemistry, maths

        for (int i = 0; i < n; i++) {
            scores[i][0] = rand.nextInt(100); // physics
            scores[i][1] = rand.nextInt(100); // chemistry
            scores[i][2] = rand.nextInt(100); // maths
        }

        return scores;
    }

    // Method to calculate total, average, percentage (returns 2D array: [n][3])
    // [total, average, percentage]
    public static double[][] calculateTotals(int[][] scores) {
        int n = scores.length;
        double[][] results = new double[n][3];

        for (int i = 0; i < n; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            // Round to 2 decimal places
            average = Math.round(average * 100.0) / 100.0;
            percentage = Math.round(percentage * 100.0) / 100.0;

            results[i][0] = total;
            results[i][1] = average;
            results[i][2] = percentage;
        }
        return results;
    }

    // Method to calculate grades based on percentage
    // Returns a 1D array of grades (String)
    // Assuming grading as:
    // >= 90% -> A, 80-89 -> B, 70-79 -> C, 60-69 -> D, 50-59 -> E, <50 -> F
    public static String[] calculateGrades(double[][] results) {
        int n = results.length;
        String[] grades = new String[n];

        for (int i = 0; i < n; i++) {
            double percentage = results[i][2];
            if (percentage >= 90) grades[i] = "A";
            else if (percentage >= 80) grades[i] = "B";
            else if (percentage >= 70) grades[i] = "C";
            else if (percentage >= 60) grades[i] = "D";
            else if (percentage >= 50) grades[i] = "E";
            else grades[i] = "F";
        }
        return grades;
    }

    // Method to display the scorecard
    public static void displayScorecard(int[][] scores, double[][] results, String[] grades) {
        System.out.printf("%-8s %-8s %-10s %-8s %-7s %-8s %-10s\n",
                "Student", "Physics", "Chemistry", "Maths", "Total", "Average", "Percentage", "Grade");
        System.out.println("--------------------------------------------------------------------------------");

        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%-8d %-8d %-10d %-8d %-7.0f %-8.2f %-10.2f %-5s\n",
                    i + 1, scores[i][0], scores[i][1], scores[i][2],
                    results[i][0], results[i][1], results[i][2], grades[i]);
        }
    }

    public static void main(String[] args) {
        int numberOfStudents = 10;

        // Generate random scores for students
        int[][] scores = generateScores(numberOfStudents);

        // Calculate total, average and percentage
        double[][] results = calculateTotals(scores);

        // Calculate grades
        String[] grades = calculateGrades(results);

        // Display scorecard
        displayScorecard(scores, results, grades);
    }
}
