class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;

    Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    public double getCGPA() {
        return CGPA;
    }

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }
}

class PostgraduateStudent extends Student {
    String researchTopic;

    PostgraduateStudent(int rollNumber, String name, double CGPA, String researchTopic) {
        super(rollNumber, name, CGPA);
        this.researchTopic = researchTopic;
    }

    void displayDetails() {
        // Accessing protected member 'name' from superclass
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + getCGPA());
        System.out.println("Research Topic: " + researchTopic);
    }
}

public class UniversityManagementSystem {
    public static void main(String[] args) {
        PostgraduateStudent pgStudent = new PostgraduateStudent(101, "Alice", 3.8, "AI Research");
        pgStudent.displayDetails();

        // Modifying CGPA using public setter
        pgStudent.setCGPA(3.9);
        System.out.println("Updated CGPA: " + pgStudent.getCGPA());
    }
}
