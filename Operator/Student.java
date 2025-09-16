class Student {
    static String universityName = "Global University";
    static int totalStudents = 0;

    String name;
    final int rollNumber;
    char grade;

    Student(String name, int rollNumber, char grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }

    static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }

    void displayDetails() {
        if (this instanceof Student) {
            System.out.println("University: " + universityName);
            System.out.println("Name: " + name);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Grade: " + grade);
        }
    }

    void updateGrade(char newGrade) {
        if (this instanceof Student) {
            this.grade = newGrade;
            System.out.println("Grade updated to: " + grade + " for Roll Number: " + rollNumber);
        }
    }
}

public class UniversityStudentManagement {
    public static void main(String[] args) {
        Student s1 = new Student("John Doe", 1001, 'B');
        Student s2 = new Student("Jane Smith", 1002, 'A');

        s1.displayDetails();
        System.out.println();
        s2.displayDetails();
        System.out.println();

        Student.displayTotalStudents();
        System.out.println();

        s1.updateGrade('A');
        s1.displayDetails();
    }
}
