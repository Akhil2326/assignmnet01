package com.bridgelabz.oops.levelone;

public class InventoryManager {
    public static void main(String[] args) {
        // Creating item objects
        Item item1 = new Item("01AA", "Water Bottle", 500.0);
        Item item2 = new Item("01BB", "Rice", 700.0);
        Item item3 = new Item("02AA", "Blackboard", 400.0);

        // Displaying item details
        item1.displayItemDetails();
        item2.displayItemDetails();
        item3.displayItemDetails();

        // Example: Calculating total cost for quantity
        int quantity = 3;
        double total = item2.calculateTotalCost(quantity);
        System.out.println("Total cost for " + quantity + " units of " + item2.itemName + ": ₹" + total);
    }
}
