class Employee {
    String name;
    String designation;

    Employee(String name, String designation) {
        this.name = name;
        this.designation = designation;
    }

    void displayEmployee() {
        System.out.println("Employee: " + name + ", Designation: " + designation);
    }
}
