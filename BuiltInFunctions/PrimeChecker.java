import java.util.InputMismatchException;
import java.util.Scanner;

public class PrimeChecker {
    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter a number:");
            int num = scanner.nextInt();
            System.out.println(num + " is " + (isPrime(num) ? "a prime number." : "not a prime number."));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter an integer.");
        } finally {
            scanner.close();
        }
    }
}

