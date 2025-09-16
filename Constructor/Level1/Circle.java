class Circle {
    double radius;

    // Default constructor calls parameterized constructor with default radius 1.0
    Circle() {
        this(1.0);
    }

    // Parameterized constructor
    Circle(double radius) {
        this.radius = radius;
    }
}
