import java.util.*;

class Company {
    private String companyName;
    private List<Department> departments;

    Company(String companyName) {
        this.companyName = companyName;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(String departmentName) {
        Department department = new Department(departmentName);
        departments.add(department);
        System.out.printf("Department \"%s\" added to company \"%s\".%n", departmentName, companyName);
    }

    public void addEmployeeToDepartment(String departmentName, String employeeName) {
        for (Department dept : departments) {
            if (dept.getDepartmentName().equals(departmentName)) {
                dept.addEmployee(employeeName);
                return;
            }
        }
        System.out.printf("Department \"%s\" not found in company \"%s\".%n", departmentName, companyName);
    }

    public void printCompanyInfo() {
        System.out.println("\n********* Company Info **********");
        System.out.println("Company Name: " + this.companyName);
        if (departments.isEmpty()) {
            System.out.println("No departments in the company.");
        } else {
            for (Department dept : departments) {
                dept.printDepartmentInfo();
            }
        }
        System.out.println("*********************************\n");
    }

    public void closeCompany() {
        System.out.printf("Company \"%s\" is closing. All departments and employees will be removed.%n", companyName);
        departments.clear();
    }

    private class Department {
        private String departmentName;
        private List<Employee> employees;

        Department(String departmentName) {
            this.departmentName = departmentName;
            this.employees = new ArrayList<>();
        }

        public String getDepartmentName() {
            return this.departmentName;
        }

        public void addEmployee(String employeeName) {
            Employee employee = new Employee(employeeName);
            employees.add(employee);
            System.out.printf("Employee \"%s\" added to department \"%s\".%n", employeeName, departmentName);
        }

        public void printDepartmentInfo() {
            System.out.println("\n--- Department: " + departmentName + " ---");
            if (employees.isEmpty()) {
                System.out.println("No employees in this department.");
            } else {
                System.out.println("Employees: " + employees);
            }
        }

        private class Employee {
            private String name;

            Employee(String name) {
                this.name = name;
            }

            @Override
            public String toString() {
                return name;
            }
        }
    }
}

public class CompanyAndDepartments {
    public static void main(String[] args) {
        Company company = new Company("TechCorp");

        company.addDepartment("IT");
        company.addDepartment("HR");

        company.addEmployeeToDepartment("IT", "Alice");
        company.addEmployeeToDepartment("IT", "Bob");
        company.addEmployeeToDepartment("HR", "Charlie");

        company.printCompanyInfo();

        company.closeCompany();
        company.printCompanyInfo();
    }
}

