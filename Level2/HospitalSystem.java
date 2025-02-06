import java.util.*;

class Hospital {
    private String hospitalName;
    private List<Doctor> doctors;
    private List<Patient> patients;

    Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        if (doctor == null) {
            System.out.println("Cannot add a null doctor!");
            return;
        }
        doctors.add(doctor);
        System.out.printf("Doctor \"%s\" added to hospital \"%s\".%n", doctor.getName(), hospitalName);
    }

    public void addPatient(Patient patient) {
        if (patient == null) {
            System.out.println("Cannot add a null patient!");
            return;
        }
        patients.add(patient);
        System.out.printf("Patient \"%s\" added to hospital \"%s\".%n", patient.getName(), hospitalName);
    }

    public void printHospitalInfo() {
        System.out.println("\n********* Hospital Info **********");
        System.out.println("Hospital Name: " + this.hospitalName);
        if (doctors.isEmpty()) {
            System.out.println("No doctors in the hospital.");
        } else {
            System.out.println("Doctors:");
            for (Doctor doctor : doctors) {
                System.out.println("- " + doctor.getName());
            }
        }
        if (patients.isEmpty()) {
            System.out.println("No patients in the hospital.");
        } else {
            System.out.println("Patients:");
            for (Patient patient : patients) {
                System.out.println("- " + patient.getName());
            }
        }
        System.out.println("*********************************\n");
    }
}

class Doctor {
    private String name;
    private List<Patient> patients;

    Doctor(String name) {
        this.name = name;
        this.patients = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void consult(Patient patient) {
        if (patient == null) {
            System.out.println("Cannot consult a null patient!");
            return;
        }
        if (!patients.contains(patient)) {
            patients.add(patient);
            System.out.printf("Doctor \"%s\" is now consulting patient \"%s\".%n", name, patient.getName());
        } else {
            System.out.printf("Doctor \"%s\" is already consulting patient \"%s\".%n", name, patient.getName());
        }
    }

    public void printConsultedPatients() {
        System.out.println("\n*** Doctor: " + name + " ***");
        if (patients.isEmpty()) {
            System.out.println("No patients consulted yet.");
        } else {
            System.out.println("Consulted Patients:");
            for (Patient patient : patients) {
                System.out.println("- " + patient.getName());
            }
        }
        System.out.println("*********************************\n");
    }
}

class Patient {
    private String name;
    private List<Doctor> doctors;

    Patient(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

}

public class HospitalSystem {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City Health Center");

        Doctor doctor1 = new Doctor("Dr. Adams");
        Doctor doctor2 = new Doctor("Dr. Lee");

        Patient patient1 = new Patient("John Doe");
        Patient patient2 = new Patient("Jane Smith");

        hospital.addDoctor(doctor1);
        hospital.addDoctor(doctor2);
        hospital.addPatient(patient1);
        hospital.addPatient(patient2);

        doctor1.consult(patient1);
        doctor1.consult(patient2);

        doctor2.consult(patient1);

        hospital.printHospitalInfo();

        doctor1.printConsultedPatients();
        doctor2.printConsultedPatients();
    }
}

