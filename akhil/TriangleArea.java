package akhil;

import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter base in cm: ");
        double base = input.nextDouble();
        System.out.print("Enter height in cm: ");
        double height = input.nextDouble();
        double areaCm = 0.5 * base * height;
        double baseInches = base / 2.54;
        double heightInches = height / 2.54;
        double areaInches = 0.5 * baseInches * heightInches;
        System.out.println("The area of the triangle is " + areaCm + " square cm and " + areaInches + " square inches");
        input.close();
    }
}
