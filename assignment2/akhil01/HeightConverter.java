package akhil01;

import java.util.Scanner;

public class HeightConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your height in cm: ");
        double cm = input.nextDouble();
        int feet = (int) (cm / 30.48);
        int inches = (int) ((cm / 2.54) % 12);
        System.out.println("Your Height in cm is " + cm + " while in feet is " + feet + " and inches is " + inches);
        input.close();
    }
}
