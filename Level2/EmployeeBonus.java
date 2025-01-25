import java.util.Scanner;
class EmployeeBonus {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double[] salaries = new double[10];
        int[] yearsOfService = new int[10];
        double[] bonuses = new double[10];
        double totalBonus = 0, totalOldSalary = 0, totalNewSalary = 0;

        for (int i = 0; i < 10; i++) {
            System.out.printf("Enter salary for employee %d: ", i + 1);
            double salary = input.nextDouble();
            
            while (salary <= 0) {
                System.out.println("Invalid salary. Please enter a positive value.");
                salary = input.nextDouble();
            }

            System.out.printf("Enter years of service for employee %d: ", i + 1);
            int years = input.nextInt();
            
            while (years < 0) {
                System.out.println("Invalid years of service. Please enter a non-negative value.");
                years = input.nextInt();
            }

            salaries[i] = salary;
            yearsOfService[i] = years;

            double bonus = (years > 5) ? 0.05 * salary : 0.02 * salary;
            bonuses[i] = bonus;
            totalBonus += bonus;
            totalOldSalary += salary;
            totalNewSalary += (salary + bonus);
        }

        System.out.println("\nSummary:");
        System.out.printf("Total Bonus: %.2f\n", totalBonus);
        System.out.printf("Total Old Salary: %.2f\n", totalOldSalary);
        System.out.printf("Total New Salary: %.2f\n", totalNewSalary);
    }
}
