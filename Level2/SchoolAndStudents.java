import java.util.*;

class School {
    private String schoolName;
    private List<Student> students;

    School(String schoolName) {
        this.schoolName = schoolName;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        if (student == null) {
            System.out.println("Cannot add a null student!");
            return;
        }
        students.add(student);
        System.out.printf("Student \"%s\" added to school \"%s\".%n", student.getName(), schoolName);
    }

    public void printSchoolInfo() {
        System.out.println("\n********* School Info **********");
        System.out.println("School Name: " + this.schoolName);
        if (students.isEmpty()) {
            System.out.println("No students enrolled.");
        } else {
            System.out.println("Enrolled Students:");
            for (Student student : students) {
                System.out.println("- " + student.getName());
            }
        }
        System.out.println("*********************************\n");
    }
}

class Student {
    private String name;
    private List<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void enrollInCourse(Course course) {
        if (course == null) {
            System.out.println("Cannot enroll in a null course!");
            return;
        }
        if (!courses.contains(course)) {
            courses.add(course);
            course.addStudent(this);
            System.out.printf("Student \"%s\" enrolled in course \"%s\".%n", name, course.getCourseName());
        } else {
            System.out.printf("Student \"%s\" is already enrolled in course \"%s\".%n", name, course.getCourseName());
        }
    }

    public void printEnrolledCourses() {
        System.out.println("\n*** Courses for Student: " + name + " ***");
        if (courses.isEmpty()) {
            System.out.println("No courses enrolled.");
        } else {
            for (Course course : courses) {
                System.out.println("- " + course.getCourseName());
            }
        }
        System.out.println("*********************************\n");
    }
}

class Course {
    private String courseName;
    private List<Student> enrolledStudents;

    public Course(String courseName) {
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void addStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
        }
    }

    public void printEnrolledStudents() {
        System.out.println("\n*** Students enrolled in Course: " + courseName + " ***");
        if (enrolledStudents.isEmpty()) {
            System.out.println("No students enrolled.");
        } else {
            for (Student student : enrolledStudents) {
                System.out.println("- " + student.getName());
            }
        }
        System.out.println("*********************************\n");
    }
}

public class SchoolAndStudents {
    public static void main(String[] args) {
        School school = new School("Greenwood High");

        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");

        school.addStudent(student1);
        school.addStudent(student2);

        Course course1 = new Course("Mathematics");
        Course course2 = new Course("Physics");

        student1.enrollInCourse(course1);
        student1.enrollInCourse(course2);
        student2.enrollInCourse(course1);

        school.printSchoolInfo();

        student1.printEnrolledCourses();
        student2.printEnrolledCourses();

        course1.printEnrolledStudents();
        course2.printEnrolledStudents();
    }
}

