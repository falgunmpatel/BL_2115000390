// Employee class definition
public class Employee {
    // Private fields for encapsulation
    private String name;
    private int id;
    private double salary;

    // Constructor to initialize Employee attributes
    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // Method to display Employee details
    public void displayDetails() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: $" + salary);
    }

    // Main method to test Employee class
    public static void main(String[] args) {
        // Creating Employee object
        Employee emp1 = new Employee("John Doe", 101, 50000.0);

        // Displaying Employee details
        System.out.println("=== Employee Details ===");
        emp1.displayDetails();
    }
}
