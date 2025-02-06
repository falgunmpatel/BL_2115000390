import java.util.*;

class University {
    private String universityName;
    private List<Department> departments;
    private List<Faculty> faculties;

    University(String universityName) {
        this.universityName = universityName;
        this.departments = new ArrayList<>();
        this.faculties = new ArrayList<>();
    }

    public void addDepartment(String departmentName) {
        Department department = new Department(departmentName);
        departments.add(department);
        System.out.printf("Department \"%s\" added to university \"%s\".%n", departmentName, universityName);
    }

    public void addFaculty(Faculty faculty) {
        if (faculty == null) {
            System.out.println("Cannot add a null faculty member!");
            return;
        }
        faculties.add(faculty);
        System.out.printf("Faculty \"%s\" added to university \"%s\".%n", faculty.getName(), universityName);
    }

    public void assignFacultyToDepartment(String facultyName, String departmentName) {
        Faculty faculty = findFaculty(facultyName);
        Department department = findDepartment(departmentName);

        if (faculty == null) {
            System.out.printf("Faculty \"%s\" not found in university \"%s\".%n", facultyName, universityName);
            return;
        }
        if (department == null) {
            System.out.printf("Department \"%s\" not found in university \"%s\".%n", departmentName, universityName);
            return;
        }

        department.addFaculty(faculty);
        System.out.printf("Faculty \"%s\" assigned to department \"%s\".%n", facultyName, departmentName);
    }

    private Faculty findFaculty(String facultyName) {
        for (Faculty faculty : faculties) {
            if (faculty.getName().equals(facultyName)) {
                return faculty;
            }
        }
        return null;
    }

    private Department findDepartment(String departmentName) {
        for (Department department : departments) {
            if (department.getDepartmentName().equals(departmentName)) {
                return department;
            }
        }
        return null;
    }

    public void printUniversityInfo() {
        System.out.println("\n********* University Info **********");
        System.out.println("University Name: " + this.universityName);

        if (departments.isEmpty()) {
            System.out.println("No departments in the university.");
        } else {
            System.out.println("Departments:");
            for (Department department : departments) {
                department.printDepartmentInfo();
            }
        }

        if (faculties.isEmpty()) {
            System.out.println("No faculty members associated.");
        } else {
            System.out.println("------ Faculty Members -----");
            for (Faculty faculty : faculties) {
                System.out.println("- " + faculty.getName());
            }
            System.out.println("---------------------------\n");
        }
        System.out.println("*********************************\n");
    }

    public void closeUniversity() {
        System.out.printf("University \"%s\" is closing. All departments will be removed.%n", universityName);
        departments.clear();
    }

    private class Department {
        private String departmentName;
        private List<Faculty> facultyMembers;

        Department(String departmentName) {
            this.departmentName = departmentName;
            this.facultyMembers = new ArrayList<>();
        }

        public String getDepartmentName() {
            return this.departmentName;
        }

        public void addFaculty(Faculty faculty) {
            if (!facultyMembers.contains(faculty)) {
                facultyMembers.add(faculty);
            }
        }

        public void printDepartmentInfo() {
            System.out.println("--- Department: " + departmentName + " ---");
            if (facultyMembers.isEmpty()) {
                System.out.println("No faculty assigned.");
            } else {
                System.out.println("Faculty Members:");
                for (Faculty faculty : facultyMembers) {
                    System.out.println("- " + faculty.getName());
                }
            }
            System.out.println("---------------------------\n");
        }
    }
}

class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

public class UniversitySystem {
    public static void main(String[] args) {
        University university = new University("Oxford University");

        university.addDepartment("Computer Science");
        university.addDepartment("Physics");

        Faculty faculty1 = new Faculty("Dr. Smith");
        Faculty faculty2 = new Faculty("Prof. Johnson");

        university.addFaculty(faculty1);
        university.addFaculty(faculty2);

        university.assignFacultyToDepartment("Dr. Smith", "Computer Science");
        university.assignFacultyToDepartment("Prof. Johnson", "Physics");

        university.printUniversityInfo();

        university.closeUniversity();
        university.printUniversityInfo();
    }
}

