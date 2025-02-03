class Employee {
    static String companyName = "TechCorp";
    static int totalEmployees = 0;
    final int id;
    String name;
    String designation;

    Employee(String name, String designation, int id) {
        this.name = name;
        this.designation = designation;
        this.id = id;
        totalEmployees++;
    }

    static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    void displayEmployeeInfo() {
        System.out.println("*********************");
        System.out.println();

        System.out.println("Employee Info: ");
        System.out.println("Name: " + this.name);
        System.out.println("Designation: " + this.designation);
        System.out.println("Employee ID: " + this.id);
        System.out.println("Company: " + companyName);

        System.out.println();
        System.out.println("*********************");
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Alice", "Developer", 101);
        Employee emp2 = new Employee("Bob", "Manager", 102);

        Employee.displayTotalEmployees();

        if (emp1 instanceof Employee) {
            emp1.displayEmployeeInfo();
        }

        if (emp2 instanceof Employee) {
            emp2.displayEmployeeInfo();
        }
    }
}

