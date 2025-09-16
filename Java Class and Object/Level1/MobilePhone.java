package com.bridgelabz.oops.levelone;

public class MobilePhone {
    // Declaring variables to hold phone details
    String brand;
    String model;
    double price;

    // Constructor
    MobilePhone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    // Method to display mobile details
    public void displayMobile() {
        System.out.println("Brand of Mobile : " + brand);
        System.out.println("Model of Mobile : " + model);
        System.out.printf("Price of Mobile : ₹%.2f\n", price);
        System.out.println("------------------------------");
    }

    // Main method to create and display mobile phones
    public static void main(String[] args) {
        MobilePhone mobile1 = new MobilePhone("VIVO", "VIVO V29", 15999);
        MobilePhone mobile2 = new MobilePhone("ONE PLUS", "ONE PLUS Nord 4", 39999);
        MobilePhone mobile3 = new MobilePhone("APPLE", "iPhone 16 Pro", 79999);

        // Display details
        mobile1.displayMobile();
        mobile2.displayMobile();
        mobile3.displayMobile();
    }
}
