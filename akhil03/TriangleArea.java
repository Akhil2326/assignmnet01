package akhil03;

import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the base in cm: ");
        double base = input.nextDouble();
        System.out.print("Enter the height in cm: ");
        double height = input.nextDouble();

        double areaCm = 0.5 * base * height;
        double baseIn = base / 2.54;
        double heightIn = height / 2.54;
        double areaIn = 0.5 * baseIn * heightIn;

        System.out.println("The Area of the triangle in sq in is " + areaIn +
            " and sq cm is " + areaCm);
        input.close();
    }
}
