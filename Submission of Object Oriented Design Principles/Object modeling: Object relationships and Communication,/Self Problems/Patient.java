import java.util.ArrayList;

class Patient {
    String name;
    ArrayList<Doctor> consultedDoctors;

    Patient(String name) {
        this.name = name;
        consultedDoctors = new ArrayList<>();
    }

    void addDoctor(Doctor doctor) {
        if (!consultedDoctors.contains(doctor)) {
            consultedDoctors.add(doctor);
        }
    }

    void viewConsultedDoctors() {
        System.out.println("Patient: " + name + " has consulted:");
        if (consultedDoctors.isEmpty()) {
            System.out.println("No doctors yet.");
        } else {
            for (Doctor d : consultedDoctors) {
                System.out.println("- Dr. " + d.name + " (" + d.specialty + ")");
            }
        }
        System.out.println();
    }
}
