import java.io.*;

class Student {
  int rollNumber;
  String name;
  double gpa;

  public Student(int rollNumber, String name, double gpa) {
    this.rollNumber = rollNumber;
    this.name = name;
    this.gpa = gpa;
  }
}

public class StudentDataHandler {
  private static final String FILE_NAME = "student_data.bin";

  public static void main(String[] args) {
    Student student = new Student(005, "Student_01", 3.75);
    writeStudentData(student);
    readStudentData();
  }

  private static void writeStudentData(Student student) {
    try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_NAME))) {
      dos.writeInt(student.rollNumber);
      dos.writeUTF(student.name);
      dos.writeDouble(student.gpa);
      System.out.println("Student data written successfully!");
    } catch (IOException e) {
      System.out.println("Error writing data: " + e.getMessage());
    }
  }

  private static void readStudentData() {
    try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_NAME))) {
      int rollNumber = dis.readInt();
      String name = dis.readUTF();
      double gpa = dis.readDouble();
      System.out.println("Retrieved Student Data:");
      System.out.println("Roll Number: " + rollNumber);
      System.out.println("Name: " + name);
      System.out.println("GPA: " + gpa);
    } catch (IOException e) {
      System.out.println("Error reading data: " + e.getMessage());
    }
  }
}
