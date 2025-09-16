class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        }
    }
}

class Manager extends Employee {
    String managerLevel;

    Manager(int employeeID, String department, double salary, String managerLevel) {
        super(employeeID, department, salary);
        this.managerLevel = managerLevel;
    }

    void displayManagerDetails() {
        // Access public employeeID directly
        System.out.println("Employee ID: " + employeeID);
        // Access protected department directly
        System.out.println("Department: " + department);
        // Access private salary via getter
        System.out.println("Salary: $" + getSalary());
        System.out.println("Manager Level: " + managerLevel);
    }
}

public class EmployeeRecords {
    public static void main(String[] args) {
        Manager mgr = new Manager(101, "Sales", 75000, "Senior");
        mgr.displayManagerDetails();

        mgr.setSalary(80000);
        System.out.println("Updated Salary: $" + mgr.getSalary());
    }
}
