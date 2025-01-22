import java.util.Scanner;
public class SimpleInterestCalculator {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the principal amount: ");
            double principal = scanner.nextDouble();

            System.out.print("Enter the rate of interest: ");
            double rate = scanner.nextDouble();

            System.out.print("Enter the time period (in years): ");
            double time = scanner.nextDouble();

            double simpleInterest = (principal * rate * time) / 100;

            System.out.println("Simple Interest: " + simpleInterest);
        }
    }
}
