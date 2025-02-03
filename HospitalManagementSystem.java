class Patient {
    private static String hospitalName = "City Hospital";
    private static int totalPatients = 0;
    private final int patientID;
    private String name;
    private int age;
    private String ailment;

    Patient(String name, int age, String ailment, int patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;
    }

    static void getTotalPatients() {
        System.out.println("Total Patients Admitted: " + totalPatients);
    }

    void displayPatientDetails() {
        System.out.println("*********************");
        System.out.println();

        System.out.println("Patient Info: ");
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("Ailment: " + this.ailment);
        System.out.println("Patient ID: " + this.patientID);
        System.out.println("Hospital: " + hospitalName);

        System.out.println();
        System.out.println("*********************");
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    String getAilment() {
        return ailment;
    }

    int getPatientID() {
        return patientID;
    }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {
        Patient patient1 = new Patient("John Doe", 45, "Flu", 101);
        Patient patient2 = new Patient("Jane Smith", 30, "Headache", 102);

        Patient.getTotalPatients();

        if (patient1 instanceof Patient) {
            patient1.displayPatientDetails();
        }

        if (patient2 instanceof Patient) {
            patient2.displayPatientDetails();
        }
    }
}

