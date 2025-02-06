import java.util.*;

class University {
    private String universityName;
    private List<Student> students;
    private List<Professor> professors;
    private List<Course> courses;

    University(String universityName) {
        this.universityName = universityName;
        this.students = new ArrayList<>();
        this.professors = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public void addStudent(Student student) {
        if (student == null) {
            System.out.println("Cannot add a null student!");
            return;
        }
        students.add(student);
        System.out.printf("Student \"%s\" added to university \"%s\".%n", student.getName(), universityName);
    }

    public void addProfessor(Professor professor) {
        if (professor == null) {
            System.out.println("Cannot add a null professor!");
            return;
        }
        professors.add(professor);
        System.out.printf("Professor \"%s\" added to university \"%s\".%n", professor.getName(), universityName);
    }

    public void addCourse(Course course) {
        if (course == null) {
            System.out.println("Cannot add a null course!");
            return;
        }
        courses.add(course);
        System.out.printf("Course \"%s\" added to university \"%s\".%n", course.getName(), universityName);
    }

    public void printUniversityInfo() {
        System.out.println("\n********* University Info **********");
        System.out.println("University Name: " + this.universityName);

        if (students.isEmpty()) {
            System.out.println("No students in the university.");
        } else {
            System.out.println("Students:");
            for (Student student : students) {
                System.out.println("- " + student.getName());
            }
        }

        if (professors.isEmpty()) {
            System.out.println("No professors in the university.");
        } else {
            System.out.println("Professors:");
            for (Professor professor : professors) {
                System.out.println("- " + professor.getName());
            }
        }

        if (courses.isEmpty()) {
            System.out.println("No courses available.");
        } else {
            System.out.println("Courses:");
            for (Course course : courses) {
                System.out.println("- " + course.getName());
            }
        }
        System.out.println("*********************************\n");
    }
}

class Student {
    private String name;
    private List<Course> courses;

    Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void enrollCourse(Course course) {
        if (course == null) {
            System.out.println("Cannot enroll in a null course!");
            return;
        }
        courses.add(course);
        System.out.printf("Student \"%s\" has enrolled in course \"%s\".%n", name, course.getName());
    }

    public void printEnrolledCourses() {
        System.out.println("\n*** Student: " + name + " ***");
        if (courses.isEmpty()) {
            System.out.println("No courses enrolled yet.");
        } else {
            System.out.println("Enrolled Courses:");
            for (Course course : courses) {
                System.out.println("- " + course.getName());
            }
        }
        System.out.println("*********************************\n");
    }
}

class Professor {
    private String name;
    private List<Course> courses;

    Professor(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void assignCourse(Course course) {
        if (course == null) {
            System.out.println("Cannot assign a null course!");
            return;
        }
        courses.add(course);
        System.out.printf("Professor \"%s\" is now teaching course \"%s\".%n", name, course.getName());
    }

    public void printTeachingCourses() {
        System.out.println("\n*** Professor: " + name + " ***");
        if (courses.isEmpty()) {
            System.out.println("No courses taught yet.");
        } else {
            System.out.println("Teaching Courses:");
            for (Course course : courses) {
                System.out.println("- " + course.getName());
            }
        }
        System.out.println("*********************************\n");
    }
}

class Course {
    private String name;
    private Professor professor;

    Course(String name) {
        this.name = name;
        this.professor = null;  // Initially no professor assigned
    }

    public String getName() {
        return this.name;
    }

    public void assignProfessor(Professor professor) {
        if (professor == null) {
            System.out.println("Cannot assign a null professor!");
            return;
        }
        this.professor = professor;
        System.out.printf("Course \"%s\" is now assigned to professor \"%s\".%n", name, professor.getName());
    }

    public void printCourseInfo() {
        System.out.println("\n--- Course: " + name + " ---");
        if (professor == null) {
            System.out.println("No professor assigned yet.");
        } else {
            System.out.println("Assigned Professor: " + professor.getName());
        }
        System.out.println("*********************************\n");
    }
}

public class UniversityManagementSystem {
    public static void main(String[] args) {
        University university = new University("Tech University");

        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");

        Professor professor1 = new Professor("Dr. Smith");
        Professor professor2 = new Professor("Dr. Johnson");

        Course course1 = new Course("Data Structures");
        Course course2 = new Course("Algorithms");
        Course course3 = new Course("Operating Systems");

        university.addStudent(student1);
        university.addStudent(student2);
        university.addProfessor(professor1);
        university.addProfessor(professor2);
        university.addCourse(course1);
        university.addCourse(course2);
        university.addCourse(course3);

        student1.enrollCourse(course1);
        student1.enrollCourse(course2);
        student2.enrollCourse(course2);
        student2.enrollCourse(course3);

        professor1.assignCourse(course1);
        professor1.assignCourse(course2);
        professor2.assignCourse(course3);

        university.printUniversityInfo();

        student1.printEnrolledCourses();
        student2.printEnrolledCourses();

        professor1.printTeachingCourses();
        professor2.printTeachingCourses();
    }
}

