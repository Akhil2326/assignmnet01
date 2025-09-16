package com.bridgelabz.oops.levelone;

public class Circle {

    // Non-static variable
    double radius;

    // Constructor
    Circle(double radius) {
        this.radius = radius;
    }

    // Method to calculate and display area of the circle
    public void areaCircle() {
        System.out.printf("Area of circle: %.4f", (Math.PI * radius * radius));
    }

    // Method to calculate and display circumference of the circle
    public void circumferenceCircle() {
        System.out.printf("\nCircumference of circle: %.4f", (2 * Math.PI * radius));
    }

    public static void main(String[] args) {
        Circle circle = new Circle(2.5);  // Constructor invocation

        circle.areaCircle();              // Call to area method
        circle.circumferenceCircle();     // Call to circumference method
    }
}
