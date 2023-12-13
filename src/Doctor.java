import java.util.Scanner;

class Doctor {
    String name;
    String specialization;
    int doctorNumber;
    boolean isActive;

    public Doctor(String name, String specialization, int doctorNumber, boolean isActive) {
        this.name = name;
        this.specialization = specialization;
        this.doctorNumber = doctorNumber;
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        String status = isActive ? "Active" : "Inactive";
        return "Doctor #" + doctorNumber + ": " + name + " (" + specialization + ") - Status: " + status;
    }
}

public class DoctorList {
    private static final int MAX_DOCTORS = 10;
    private Doctor[] doctors;
    private int size;

    public DoctorList() {
        doctors = new Doctor[MAX_DOCTORS];
        size = 0;
    }

    public void addDoctor(Doctor doctor) {
        if (size < MAX_DOCTORS) {
            doctors[size++] = doctor;
            System.out.println("Doctor added.");
        } else {
            System.out.println("Cannot add more doctors. Maximum limit reached.");
        }
    }

    public void deleteDoctor(int doctorNumber) {
        for (int i = 0; i < size; i++) {
            if (doctors[i].doctorNumber == doctorNumber) {
                // Shift elements to fill the gap
                for (int j = i; j < size - 1; j++) {
                    doctors[j] = doctors[j + 1];
                }
                doctors[size - 1] = null; // Set the last element to null
                size--;
                System.out.println("Doctor #" + doctorNumber + " deleted.");
                return;
            }
        }
        System.out.println("Doctor #" + doctorNumber + " not found.");
    }

    public void displayDoctors() {
        for (int i = 0; i < size; i++) {
            System.out.println(doctors[i]);
        }
    }

    public static void main(String[] args) {
        DoctorList doctorList = new DoctorList();
        Scanner scanner = new Scanner(System.in);

        doctorList.addDoctor(new Doctor("Dr. Smith", "Cardiologist", 1, true));
        doctorList.addDoctor(new Doctor("Dr. Johnson", "Dermatologist", 2, true));
        doctorList.addDoctor(new Doctor("Dr. Brown", "Pediatrician", 3, false));

        System.out.println("Before deletion:");
        doctorList.displayDoctors();

        System.out.print("\nEnter the doctor number to delete: ");
        int doctorNumberToDelete = scanner.nextInt();

        doctorList.deleteDoctor(doctorNumberToDelete);

        System.out.println("\nAfter deletion:");
        doctorList.displayDoctors();

        scanner.close();
    }
}
