import java.util.InputMismatchException;
import java.util.Scanner;

public class GCDLCMCalculator {
    public static int findGCD(int a, int b) {
        return (b == 0) ? a : findGCD(b, a % b);
    }

    public static int findLCM(int a, int b) {
        return (a * b) / findGCD(a, b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter two numbers:");
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            System.out.println("GCD: " + findGCD(num1, num2));
            System.out.println("LCM: " + findLCM(num1, num2));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter integers.");
        } finally {
            scanner.close();
        }
    }
}
