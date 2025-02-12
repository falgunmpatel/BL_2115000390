import java.util.*;

class Student {
  int rollNo;
  String name;
  int age;
  String grade;
  Student next;

  Student(String name, int age, int rollNo, String grade) {
    this.name = name;
    this.age = age;
    this.rollNo = rollNo;
    this.grade = grade;
    this.next = null;
  }
}

class StudentRecordList {
  Student head;

  void addStudentAtBeginning(String name, int age, int rollNo, String grade) {
    Student newStudent = new Student(name, age, rollNo, grade);
    newStudent.next = head;
    head = newStudent;
    System.out.println("Student added at the beginning!!");
  }

  void addStudentAtEnd(String name, int age, int rollNo, String grade) {
    Student newStudent = new Student(name, age, rollNo, grade);
    if (head == null) {
      head = newStudent;
      System.out.println("Student added at the end!!");
      return;
    }
    Student temp = head;
    while (temp.next != null) {
      temp = temp.next;
    }
    temp.next = newStudent;
    System.out.println("Student added at the end!!");
  }

  void addStudentAtIndex(String name, int age, int rollNo, String grade, int idx) {
    Student newStudent = new Student(name, age, rollNo, grade);
    if (idx == 0) {
      addStudentAtBeginning(name, age, rollNo, grade);
      return;
    }
    Student temp = head;
    int index = 0;
    while (temp != null && index != idx - 1) {
      temp = temp.next;
      index++;
    }
    if (temp == null) {
      System.out.println("Invalid Index!!!");
      return;
    }
    newStudent.next = temp.next;
    temp.next = newStudent;
    System.out.println("Student added at index" + idx + "!!");
  }

  void deleteStudentByRollNo(int rollNo) {
    if (head == null) return;
    if (head.rollNo == rollNo) {
      head = head.next;
      System.out.printf("Student with rollNo \"%s\" deleted.", rollNo);
      return;
    }
    Student temp = head, prev = null;
    while (temp != null && temp.rollNo != rollNo) {
      prev = temp;
      temp = temp.next;
    }
    if (temp == null) {
      System.out.printf("Student not found!!");
    }
    prev.next = temp.next;
    System.out.printf("Student with rollNo \"%s\" deleted.", rollNo);
  }

  void searchStudentByRollNo(int rollNo) {
    Student temp = head;
    while (temp != null && temp.rollNo != rollNo) {
      temp = temp.next;
    }
    if (temp == null) {
      System.out.println("Student not found!!");
      return;
    }
    System.out.println("********* Student Details: **********");
    System.out.printf("Student Name: %s\n", temp.name);
    System.out.printf("Student Age: %d\n", temp.age);
    System.out.printf("Student Roll No: %d\n", temp.rollNo);
    System.out.printf("Student Grade: %s\n", temp.grade);
  }

  void displayAllStudents() {
    if (head == null) {
      System.out.println("No Student Records Available!!");
      return;
    }
    Student temp = head;
    System.out.println("********* Student Records: **********");
    while (temp != null) {
      System.out.printf("\nStudent Name: %s\n", temp.name);
      System.out.printf("Student Age: %d\n", temp.age);
      System.out.printf("Student Roll No: %d\n", temp.rollNo);
      System.out.printf("Student Grade: %s\n", temp.grade);
      temp = temp.next;
    }
    System.out.println("\n*************************************");
  }
}

public class StudentRecordManagement {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    StudentRecordList studentRecord = new StudentRecordList();
    while (true) {
      System.out.println("\nStudent Record Management System");
      System.out.println("1. Add Student (Beginning)");
      System.out.println("2. Add Student (End)");
      System.out.println("3. Add Student (At Position)");
      System.out.println("4. Delete Student by Roll Number");
      System.out.println("5. Search Student by Roll Number");
      System.out.println("6. Display All Students");
      System.out.println("7. Exit");
      System.out.print("Choose an option: ");

      int choice = scanner.nextInt();
      switch (choice) {
        case 1:
          System.out.print("Enter Name, Age, Roll Number, Grade: ");
          studentRecord.addStudentAtBeginning(
              scanner.next(), scanner.nextInt(), scanner.nextInt(), scanner.next());
          break;
        case 2:
          System.out.print("Enter Name, Age, Roll Number, Grade: ");
          studentRecord.addStudentAtEnd(
              scanner.next(), scanner.nextInt(), scanner.nextInt(), scanner.next());
          break;
        case 3:
          System.out.print("Enter Name, Age, Roll Number Grade, Position: ");
          studentRecord.addStudentAtIndex(
              scanner.next(),
              scanner.nextInt(),
              scanner.nextInt(),
              scanner.next(),
              scanner.nextInt());
          break;
        case 4:
          System.out.print("Enter Roll Number to Delete: ");
          studentRecord.deleteStudentByRollNo(scanner.nextInt());
          break;
        case 5:
          System.out.print("Enter Roll Number to Search: ");
          studentRecord.searchStudentByRollNo(scanner.nextInt());
          break;
        case 6:
          studentRecord.displayAllStudents();
          break;
        case 7:
          System.out.println("Exiting program.");
          scanner.close();
          return;
        default:
          System.out.println("Invalid choice. Please try again.");
      }
    }
  }
}
