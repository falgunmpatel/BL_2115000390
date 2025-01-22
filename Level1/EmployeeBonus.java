import java.util.*;  
class EmployeeBonus {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the employee's salary:");
        double salary = input.nextDouble();

        System.out.println("Enter the years of service:");
        int yearsOfService = input.nextInt();

        if (yearsOfService > 5) {
            double bonus = salary * 0.05;
            System.out.println("The bonus is: " + bonus);
        } else {
            System.out.println("No bonus for less than 6 years of service.");
        }
    }
}
