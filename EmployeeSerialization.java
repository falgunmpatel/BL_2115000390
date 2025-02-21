import java.io.*;
import java.util.*;

class Employee implements Serializable {
  private static final long serialVersionUID = 1L;
  private int id;
  private String name;
  private String department;
  private double salary;

  public Employee(int id, String name, String department, double salary) {
    this.id = id;
    this.name = name;
    this.department = department;
    this.salary = salary;
  }

  @Override
  public String toString() {
    return "Employee{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", department='"
        + department
        + '\''
        + ", salary="
        + salary
        + '}';
  }
}

public class EmployeeSerialization {
  private static final String FILE_NAME = "employees.ser";

  public static void main(String[] args) {
    List<Employee> employees = new ArrayList<>();
    employees.add(new Employee(1, "Aashi", "IT", 50000));
    employees.add(new Employee(2, "Ayush", "Finance", 60000));
    employees.add(new Employee(3, "Akrati", "HR", 55000));
    serializeEmployees(employees);
    deserializeEmployees();
  }

  private static void serializeEmployees(List<Employee> employees) {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
      oos.writeObject(employees);
      System.out.println("Employees serialized successfully!");
    } catch (IOException e) {
      System.out.println("Error during serialization: " + e.getMessage());
    }
  }

  private static void deserializeEmployees() {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
      @SuppressWarnings("unchecked")
      ArrayList<Employee> employees = (ArrayList<Employee>) ois.readObject();
      System.out.println("Deserialized Employees:");
      for (Employee emp : employees) {
        System.out.println(emp);
      }
    } catch (IOException | ClassNotFoundException e) {
      System.out.println("Error during deserialization: " + e.getMessage());
    }
  }
}
