class Book1 {
    String title;
    String author;
    double price;
    boolean availability;

    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.availability = true; // book is available by default
    }

    boolean borrowBook() {
        if (availability) {
            availability = false;
            System.out.println("Book borrowed successfully.");
            return true;
        } else {
            System.out.println("Book is currently unavailable.");
            return false;
        }
    }
}
