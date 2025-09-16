1. Product Class
class Product {
    String productName;
    double price;

    Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    void displayProduct() {
        System.out.println("Product: " + productName + ", Price: $" + price);
    }
}

✅ 2. Order Class (Aggregates Products)
import java.util.ArrayList;

class Order {
    int orderId;
    ArrayList<Product> products;
    Customer customer;

    Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    void addProduct(Product product) {
        products.add(product);
    }

    double calculateTotal() {
        double total = 0;
        for (Product p : products) {
            total += p.price;
        }
        return total;
    }

    void displayOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customer.name);
        System.out.println("Products in this order:");
        for (Product p : products) {
            p.displayProduct();
        }
        System.out.println("Total Amount: $" + calculateTotal());
        System.out.println();
    }
}

✅ 3. Customer Class (Associates with Orders)
import java.util.ArrayList;

class Customer {
    String name;
    ArrayList<Order> orders;

    Customer(String name) {
        this.name = name;
        orders = new ArrayList<>();
    }

    void placeOrder(Order order) {
        orders.add(order);
        System.out.println(name + " placed Order ID: " + order.orderId);
    }

    void viewOrders() {
        System.out.println("Customer: " + name + " - Order History:");
        for (Order o : orders) {
            o.displayOrderDetails();
        }
    }
}

✅ 4. Main Class to Demonstrate the System
public class ECommercePlatformDemo {
    public static void main(String[] args) {
        // Create products
        Product laptop = new Product("Laptop", 1200.00);
        Product phone = new Product("Smartphone", 750.00);
        Product headphones = new Product("Headphones", 150.00);

        // Create customer
        Customer customer1 = new Customer("Alice");

        // Create orders
        Order order1 = new Order(101, customer1);
        order1.addProduct(laptop);
        order1.addProduct(headphones);

        Order order2 = new Order(102, customer1);
        order2.addProduct(phone);

        // Customer places orders
        customer1.placeOrder(order1);
        customer1.placeOrder(order2);

        // View customer orders
        customer1.viewOrders();
    }
}

✅ Sample Output:
Alice placed Order ID: 101
Alice placed Order ID: 102
Customer: Alice - Order History:
Order ID: 101
Customer: Alice
Products in this order:
Product: Laptop, Price: $1200.0
Product: Headphones, Price: $150.0
Total Amount: $1350.0

Order ID: 102
Customer: Alice
Products in this order:
Product: Smartphone, Price: $750.0
Total Amount: $750.0
