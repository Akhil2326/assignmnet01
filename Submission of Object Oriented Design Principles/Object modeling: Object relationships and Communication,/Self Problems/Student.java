1. Student Class
import java.util.ArrayList;

class Student {
    String name;
    ArrayList<Course> enrolledCourses;

    Student(String name) {
        this.name = name;
        enrolledCourses = new ArrayList<>();
    }

    void enrollCourse(Course course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
            course.addStudent(this);  // ensure two-way association
            System.out.println(name + " enrolled in " + course.courseName);
        }
    }

    void viewCourses() {
        System.out.println("Student: " + name + " is enrolled in:");
        for (Course c : enrolledCourses) {
            System.out.println("- " + c.courseName);
        }
        System.out.println();
    }
}

✅ 2. Professor Class
import java.util.ArrayList;

class Professor {
    String name;
    ArrayList<Course> teachingCourses;

    Professor(String name) {
        this.name = name;
        teachingCourses = new ArrayList<>();
    }

    void addCourse(Course course) {
        if (!teachingCourses.contains(course)) {
            teachingCourses.add(course);
        }
    }

    void viewCourses() {
        System.out.println("Professor: " + name + " is teaching:");
        for (Course c : teachingCourses) {
            System.out.println("- " + c.courseName);
        }
        System.out.println();
    }
}

✅ 3. Course Class (Aggregates Students and Professor)
import java.util.ArrayList;

class Course {
    String courseName;
    Professor professor;
    ArrayList<Student> students;

    Course(String courseName) {
        this.courseName = courseName;
        students = new ArrayList<>();
    }

    void assignProfessor(Professor prof) {
        this.professor = prof;
        prof.addCourse(this);
        System.out.println("Professor " + prof.name + " assigned to " + courseName);
    }

    void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    void viewCourseDetails() {
        System.out.println("Course: " + courseName);
        System.out.println("Professor: " + (professor != null ? professor.name : "None"));
        System.out.println("Enrolled Students:");
        if (students.isEmpty()) {
            System.out.println("None");
        } else {
            for (Student s : students) {
                System.out.println("- " + s.name);
            }
        }
        System.out.println();
    }
}

✅ 4. Main Class to Demonstrate the System
public class UniversityManagementSystem {
    public static void main(String[] args) {
        // Create professors
        Professor prof1 = new Professor("Dr. Smith");
        Professor prof2 = new Professor("Dr. Johnson");

        // Create students
        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");

        // Create courses
        Course c1 = new Course("Data Structures");
        Course c2 = new Course("Operating Systems");

        // Assign professors to courses
        c1.assignProfessor(prof1);
        c2.assignProfessor(prof2);

        // Students enroll in courses
        s1.enrollCourse(c1);
        s1.enrollCourse(c2);
        s2.enrollCourse(c1);

        // View student enrollments
        s1.viewCourses();
        s2.viewCourses();

        // View professor teaching assignments
        prof1.viewCourses();
        prof2.viewCourses();

        // View course details
        c1.viewCourseDetails();
        c2.viewCourseDetails();
    }
}

✅ Sample Output:
