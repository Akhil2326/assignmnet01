import java.util.Scanner;

public class BMICalculator {

    // Method to calculate BMI and status for each person
    // Takes 2D double array with [weight, height(cm)] and returns 2D String array [height, weight, BMI, status]
    public static String[][] calculateBMIAndStatus(double[][] hwArray) {
        int n = hwArray.length;
        String[][] results = new String[n][4];

        for (int i = 0; i < n; i++) {
            double weight = hwArray[i][0];
            double heightCm = hwArray[i][1];
            double heightM = heightCm / 100.0;

            // BMI = weight / (height in meters)^2
            double bmi = weight / (heightM * heightM);
            bmi = Math.round(bmi * 100.0) / 100.0;  // Round to 2 decimals

            // Determine BMI status
            String status;
            if (bmi < 18.5) status = "Underweight";
            else if (bmi < 25) status = "Normal";
            else if (bmi < 30) status = "Overweight";
            else status = "Obese";

            // Store values as strings
            results[i][0] = String.valueOf(heightCm);
            results[i][1] = String.valueOf(weight);
            results[i][2] = String.valueOf(bmi);
            results[i][3] = status;
        }

        return results;
    }

    // Method to display results in tabular format
    public static void displayResults(String[][] data) {
        System.out.printf("%-10s %-10s %-10s %-15s\n", "Height(cm)", "Weight(kg)", "BMI", "Status");
        System.out.println("----------------------------------------------------");

        for (int i = 0; i < data.length; i++) {
            System.out.printf("%-10s %-10s %-10s %-15s\n",
                    data[i][0], data[i][1], data[i][2], data[i][3]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 10;
        double[][] hwArray = new double[n][2]; // weight, height

        System.out.println("Enter weight (kg) and height (cm) for " + n + " persons:");

        for (int i = 0; i < n; i++) {
            System.out.print("Person " + (i + 1) + " - Weight (kg): ");
            hwArray[i][0] = sc.nextDouble();

            System.out.print("Person " + (i + 1) + " - Height (cm): ");
            hwArray[i][1] = sc.nextDouble();
        }

        // Calculate BMI and status
        String[][] results = calculateBMIAndStatus(hwArray);

        // Display the results
        System.out.println("\nBMI Results:");
        displayResults(results);

        sc.close();
    }
}
