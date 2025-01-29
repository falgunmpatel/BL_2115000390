import java.util.InputMismatchException;
import java.util.Scanner;

public class FibonacciSequence {
    public static void generateFibonacci(int terms) {
        int a = 0, b = 1;
        System.out.print("Fibonacci Sequence: " + a + " " + b + " ");
        for (int i = 2; i < terms; i++) {
            int next = a + b;
            System.out.print(next + " ");
            a = b;
            b = next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter the number of terms:");
            int terms = scanner.nextInt();
            if (terms < 1) throw new IllegalArgumentException("Number of terms must be at least 1.");
            generateFibonacci(terms);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter an integer.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
