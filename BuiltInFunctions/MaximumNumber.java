import java.util.InputMismatchException;
import java.util.Scanner;

public class MaximumNumber {
    public static int findMaximum(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter three numbers:");
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            int num3 = scanner.nextInt();
            System.out.println("Maximum number: " + findMaximum(num1, num2, num3));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter integers only.");
        } finally {
            scanner.close();
        }
    }
}

