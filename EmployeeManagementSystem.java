import java.util.List;

abstract class Employee {
  private int employeeId;
  private String name;
  private double baseSalary;

  public Employee(int employeeId, String name, double baseSalary) {
    this.employeeId = employeeId;
    this.name = name;
    this.baseSalary = baseSalary;
  }

  public int getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(int employeeId) {
    this.employeeId = employeeId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getBaseSalary() {
    return baseSalary;
  }

  public void setBaseSalary(double baseSalary) {
    this.baseSalary = baseSalary;
  }

  public abstract double calculateSalary();

  public void displayDetails() {
    System.out.println("Employee ID: " + employeeId);
    System.out.println("Name: " + name);
    System.out.println("Base Salary: " + baseSalary);
    System.out.println("Total Salary: " + calculateSalary());
  }
}

interface Department {
  void assignDepartment(String departmentName);

  String getDepartmentDetails();
}

class FullTimeEmployee extends Employee implements Department {
  private String department;

  public FullTimeEmployee(int employeeId, String name, double baseSalary) {
    super(employeeId, name, baseSalary);
  }

  @Override
  public double calculateSalary() {
    return getBaseSalary();
  }

  @Override
  public void assignDepartment(String departmentName) {
    this.department = departmentName;
  }

  @Override
  public String getDepartmentDetails() {
    return "Department: " + department;
  }
}

class PartTimeEmployee extends Employee implements Department {
  private int hoursWorked;
  private double hourlyRate;
  private String department;

  public PartTimeEmployee(int employeeId, String name, double hourlyRate, int hoursWorked) {
    super(employeeId, name, 0);
    this.hourlyRate = hourlyRate;
    this.hoursWorked = hoursWorked;
  }

  @Override
  public double calculateSalary() {
    return hoursWorked * hourlyRate;
  }

  @Override
  public void assignDepartment(String departmentName) {
    this.department = departmentName;
  }

  @Override
  public String getDepartmentDetails() {
    return "Department: " + department;
  }
}

public class EmployeeManagementSystem {
  public static void main(String[] args) {
    List<Employee> employees = new ArrayList<>();

    FullTimeEmployee emp1 = new FullTimeEmployee(101, "Alice", 50000);
    emp1.assignDepartment("HR");
    employees.add(emp1);

    PartTimeEmployee emp2 = new PartTimeEmployee(102, "Bob", 20, 80);
    emp2.assignDepartment("IT");
    employees.add(emp2);

    for (Employee emp : employees) {
      emp.displayDetails();
      if (emp instanceof Department) {
        System.out.println(((Department) emp).getDepartmentDetails());
      }
    }
  }
}
