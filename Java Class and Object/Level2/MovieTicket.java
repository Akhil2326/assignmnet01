package com.bridgelabz.oops.leveltwo;

public class MovieTicket {
    // Attributes
    private String movieName;
    private String seatNumber;
    private double price;
    private boolean isBooked;

    // Constructor
    MovieTicket(String movieName) {
        this.movieName = movieName;
        this.seatNumber = null;
        this.price = 0.0;
        this.isBooked = false;
    }

    // Method to book a ticket
    public void bookTicket(String seatNumber, double price) {
        if (isBooked) {
            System.err.println("Ticket already booked. House full!");
        } else {
            this.seatNumber = seatNumber;
            this.price = price;
            this.isBooked = true;
            System.out.println("✅ Ticket successfully booked!");
            displayTicket(); // Show booking details immediately
        }
    }

    // Method to display ticket details
    public void displayTicket() {
        if (this.isBooked) {
            System.out.println("🎬 Movie: " + this.movieName);
            System.out.println("🎟️ Seat Number: " + this.seatNumber);
            System.out.printf("💰 Price: $%.2f\n", this.price);
        } else {
            System.out.println("⚠️ Ticket has not been booked yet...");
        }
    }

    // Main method
    public static void main(String[] args) {
        MovieTicket ticket1 = new MovieTicket("Dragon");

        // Try displaying before booking
        ticket1.displayTicket();

        // Book the ticket
        ticket1.bookTicket("A10", 120.0);

        // Try rebooking (should fail)
        ticket1.bookTicket("B10", 120.0);
        ticket1.bookTicket("A11", 120.0);

        // Display final ticket info
        ticket1.displayTicket();
    }
}
