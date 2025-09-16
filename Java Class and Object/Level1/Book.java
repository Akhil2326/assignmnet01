package com.bridgelabz.oops.levelone;

public class Book {
    // Attributes of a book
    String title;
    String author;
    double price;

    // Constructor
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to display book details
    public void displayBookDetails() {
        System.out.println("Title of the book: " + title);
        System.out.println("Author of the book: " + author);
        System.out.println("Price of the book: " + price);
        System.out.println(); // Blank line between books
    }

    // Main method
    public static void main(String[] args) {
        Book book1 = new Book("2 States", "Chetan Bhagat", 500.00);
        Book book2 = new Book("Wings of Fire", "A.P.J Abdul Kalam", 500.00);

        book1.displayBookDetails();
        book2.displayBookDetails();
    }
}

