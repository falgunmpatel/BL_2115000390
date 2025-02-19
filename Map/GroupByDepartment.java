import java.util.*;

class Employee {
  private String name;
  private String department;

  public Employee(String name, String department) {
    this.name = name;
    this.department = department;
  }

  public String getName() {
    return name;
  }

  public String getDepartment() {
    return department;
  }

  @Override
  public String toString() {
    return name;
  }
}

public class GroupByDepartment {
  public static void main(String[] args) {
    List<Employee> employees =
        Arrays.asList(
            new Employee("Alice", "HR"), new Employee("Bob", "IT"), new Employee("Carol", "HR"));
    Map<String, List<Employee>> groupedByDepartment = groupByDepartment(employees);
    System.out.println(groupedByDepartment);
  }

  public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
    Map<String, List<Employee>> map = new HashMap<>();
    for (Employee employee : employees) {
      map.computeIfAbsent(employee.getDepartment(), k -> new ArrayList<>()).add(employee);
    }
    return map;
  }
}
