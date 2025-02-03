class Student {
    private static String universityName = "Global University";
    private static int totalStudents = 0;
    private final int rollNumber;
    private String name;
    private String grade;

    Student(String name, String grade, int rollNumber) {
        this.name = name;
        this.grade = grade;
        this.rollNumber = rollNumber;
        totalStudents++;
    }

    static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }

    void displayStudentInfo() {
        System.out.println("*********************");
        System.out.println();

        System.out.println("Student Info: ");
        System.out.println("Name: " + this.name);
        System.out.println("Roll Number: " + this.rollNumber);
        System.out.println("Grade: " + this.grade);
        System.out.println("University: " + universityName);

        System.out.println();
        System.out.println("*********************");
    }

    void updateGrade(String newGrade) {
        this.grade = newGrade;
    }
}

public class UniversityStudentManagement {
    public static void main(String[] args) {
        Student student1 = new Student("Alice", "A", 101);
        Student student2 = new Student("Bob", "B", 102);

        Student.displayTotalStudents();

        if (student1 instanceof Student) {
            System.out.println("\nStudent1 Info:");
            student1.displayStudentInfo();
            student1.updateGrade("A+");
            System.out.println("\nUpdated Student1 Info:");
            student1.displayStudentInfo();
        }

        if (student2 instanceof Student) {
            System.out.println("\nStudent2 Info:");
            student2.displayStudentInfo();
        }
    }
}

