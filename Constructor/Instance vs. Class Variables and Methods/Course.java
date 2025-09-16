class Course {
    String courseName;
    int duration;  // duration in hours or days
    double fee;

    static String instituteName = "Default Institute";

    Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    void displayCourseDetails() {
        System.out.println("Institute: " + instituteName);
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " units");
        System.out.println("Fee: $" + fee);
    }

    static void updateInstituteName(String newName) {
        instituteName = newName;
    }
}
