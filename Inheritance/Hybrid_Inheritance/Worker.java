interface Worker {
    void performDuties();
}

class Person {
    String name;
    int id;

    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

class Chef extends Person implements Worker {
    String specialty;

    Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    public void performDuties() {
        System.out.println("Role: Chef");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Specialty: " + specialty);
        System.out.println("Duties: Preparing meals and managing the kitchen.");
    }
}

class Waiter extends Person implements Worker {
    String section;

    Waiter(String name, int id, String section) {
        super(name, id);
        this.section = section;
    }

    public void performDuties() {
        System.out.println("Role: Waiter");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Section: " + section);
        System.out.println("Duties: Taking orders and serving customers.");
    }
}

public class RestaurantSystem {
    public static void main(String[] args) {
        Chef chef = new Chef("Gordon", 101, "Italian Cuisine");
        Waiter waiter = new Waiter("Emily", 202, "Outdoor Seating");

        chef.performDuties();
        System.out.println();
        waiter.performDuties();
    }
}
