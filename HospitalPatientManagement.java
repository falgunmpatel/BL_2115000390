import java.util.ArrayList;
import java.util.List;

abstract class Patient {
  private String patientId;
  private String name;
  private int age;

  public Patient(String patientId, String name, int age) {
    this.patientId = patientId;
    this.name = name;
    this.age = age;
  }

  public String getPatientId() {
    return patientId;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public void displayDetails() {
    System.out.println("Patient ID: " + patientId);
    System.out.println("Name: " + name);
    System.out.println("Age: " + age);
  }

  public abstract double calculateBill();
}

interface MedicalRecord {
  void addRecord(String record);

  void viewRecords();
}

class InPatient extends Patient implements MedicalRecord {
  private double dailyCharge;
  private int daysAdmitted;
  private String medicalHistory;

  public InPatient(String patientId, String name, int age, double dailyCharge, int daysAdmitted) {
    super(patientId, name, age);
    this.dailyCharge = dailyCharge;
    this.daysAdmitted = daysAdmitted;
    this.medicalHistory = "";
  }

  @Override
  public double calculateBill() {
    return dailyCharge * daysAdmitted;
  }

  @Override
  public void addRecord(String record) {
    medicalHistory += record + "\n";
  }

  @Override
  public void viewRecords() {
    System.out.println("Medical History:\n" + medicalHistory);
  }
}

class OutPatient extends Patient implements MedicalRecord {
  private double consultationFee;
  private String medicalHistory;

  public OutPatient(String patientId, String name, int age, double consultationFee) {
    super(patientId, name, age);
    this.consultationFee = consultationFee;
    this.medicalHistory = "";
  }

  @Override
  public double calculateBill() {
    return consultationFee;
  }

  @Override
  public void addRecord(String record) {
    medicalHistory += record + "\n";
  }

  @Override
  public void viewRecords() {
    System.out.println("Medical History:\n" + medicalHistory);
  }
}

public class HospitalPatientManagement {
  public static void main(String[] args) {
    List<Patient> patients = new ArrayList<>();

    InPatient patient1 = new InPatient("P101", "Alice", 45, 500, 5);
    OutPatient patient2 = new OutPatient("P202", "Bob", 30, 200);

    patient1.addRecord("Admitted for surgery.");
    patient2.addRecord("Consultation for fever.");

    patients.add(patient1);
    patients.add(patient2);

    for (Patient patient : patients) {
      patient.displayDetails();
      System.out.println("Total Bill: " + patient.calculateBill());
      if (patient instanceof MedicalRecord) {
        ((MedicalRecord) patient).viewRecords();
      }
    }
  }
}
