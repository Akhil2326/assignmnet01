package com.bridgelabz.oops.leveltwo;

public class CartItem {
    // Attributes
    private String itemName;
    private double price;
    private int quantity;

    // Constructor
    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Add item
    public void addItem(int quantityToAdd) {
        if (quantityToAdd > 0) {
            this.quantity += quantityToAdd;
            System.out.println("Added " + quantityToAdd + " of " + this.itemName + " to the cart.");
        } else {
            System.out.println("Quantity to add must be positive.");
        }
    }

    // Remove item
    public void removeItem(int quantityToRemove) {
        if (quantityToRemove <= 0) {
            System.out.println("Quantity to remove must be positive.");
        } else if (quantityToRemove > this.quantity) {
            System.out.println("Cannot remove " + quantityToRemove + " of " + this.itemName +
                               " as there are only " + this.quantity + " left.");
        } else {
            this.quantity -= quantityToRemove;
            System.out.println("Removed " + quantityToRemove + " of " + this.itemName + " from the cart.");
        }
    }

    // Total cost
    public double totalCost() {
        return this.price * this.quantity;
    }

    // Display item
    public void displayItem() {
        System.out.printf("Item: %s, Price: $%.2f, Quantity: %d\n", this.itemName, this.price, this.quantity);
    }

    // Main method
    public static void main(String[] args) {
        CartItem item1 = new CartItem("Laptop", 999.99, 1);
        
        item1.displayItem();       // Initial display
        item1.addItem(2);          // Add 2
        item1.removeItem(1);       // Remove 1

        // Show final cart status
        item1.displayItem();
        
        // Display total cost
        System.out.printf("Total cost: $%.2f\n", item1.totalCost());
    }
}
