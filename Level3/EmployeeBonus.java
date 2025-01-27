import java.util.*;
public class EmployeeBonus {
    public static int[] generateRandomSalaries() {
        int[] salaries = new int[10];
        for (int i = 0; i < 10; i++) salaries[i] = (int)(Math.random() * 90000) + 10000;
        return salaries;
    }

    public static int[] generateYearsOfService() {
        int[] years = new int[10];
        for (int i = 0; i < 10; i++) years[i] = (int)(Math.random() * 15) + 1;
        return years;
    }

    public static double calculateBonus(int salary, int years) {
        return years > 5 ? salary * 0.05 : salary * 0.02;
    }

    public static void displayBonusDetails(int[] salaries, int[] years) {
        int oldSum = 0, newSum = 0;
        double totalBonus = 0;
        System.out.println("Salary\tYears\tBonus\tNew Salary");
        for (int i = 0; i < salaries.length; i++) {
            double bonus = calculateBonus(salaries[i], years[i]);
            totalBonus += bonus;
            oldSum += salaries[i];
            newSum += salaries[i] + bonus;
            System.out.println(salaries[i] + "\t" + years[i] + "\t" + bonus + "\t" + (salaries[i] + bonus));
        }
        System.out.println("Total Old Salary: " + oldSum);
        System.out.println("Total New Salary: " + newSum);
        System.out.println("Total Bonus: " + totalBonus);
    }

    public static void main(String[] args) {
        int[] salaries = generateRandomSalaries();
        int[] years = generateYearsOfService();
        displayBonusDetails(salaries, years);
    }
} 
