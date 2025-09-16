class Product {
    static double discount = 0.0;

    final String productID;
    String productName;
    double price;
    int quantity;

    Product(String productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    void displayDetails() {
        if (this instanceof Product) {
            System.out.println("Product ID: " + productID);
            System.out.println("Product Name: " + productName);
            System.out.println("Price: $" + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Discount: " + discount + "%");
            System.out.println("Price after discount: $" + getPriceAfterDiscount());
        }
    }

    double getPriceAfterDiscount() {
        return price * quantity * (1 - discount / 100);
    }
}

public class ShoppingCartSystem {
    public static void main(String[] args) {
        Product p1 = new Product("P1001", "Laptop", 999.99, 1);
        Product p2 = new Product("P1002", "Smartphone", 499.99, 2);

        Product.updateDiscount(10.0);

        p1.displayDetails();
        System.out.println();
        p2.displayDetails();
    }
}
