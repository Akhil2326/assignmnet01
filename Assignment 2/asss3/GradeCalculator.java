import java.util.Scanner;
public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int physics = sc.nextInt();
        int chemistry = sc.nextInt();
        int maths = sc.nextInt();
        int total = physics + chemistry + maths;
        double percentage = total / 3.0;
        System.out.println("Average: " + percentage);
        if (percentage >= 90)
            System.out.println("Grade A - Excellent");
        else if (percentage >= 75)
            System.out.println("Grade B - Very Good");
        else if (percentage >= 60)
            System.out.println("Grade C - Good");
        else if (percentage >= 45)
            System.out.println("Grade D - Average");
        else
            System.out.println("Grade F - Fail");
    }
}
