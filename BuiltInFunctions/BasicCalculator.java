import java.util.InputMismatchException;
import java.util.Scanner;

public class BasicCalculator {
    public static double calculate(double num1, double num2, char operator) {
        switch (operator) {
            case '+': return num1 + num2;
            case '-': return num1 - num2;
            case '*': return num1 * num2;
            case '/': return (num2 != 0) ? num1 / num2 : Double.NaN;
            default: throw new IllegalArgumentException("Invalid operator. Use +, -, *, or /.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter two numbers:");
            double num1 = scanner.nextDouble();
            double num2 = scanner.nextDouble();
            System.out.println("Enter operator (+, -, *, /):");
            char operator = scanner.next().charAt(0);
            System.out.println("Result: " + calculate(num1, num2, operator));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter numbers.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
