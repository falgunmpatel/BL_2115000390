import java.util.Scanner;

public class AthleteRoundsCalculator {
    public static double calculateRounds(double side1, double side2, double side3, double distance) 	{
        double perimeter = side1 + side2 + side3;
        return distance / perimeter;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first side of the park: ");
        double side1 = scanner.nextDouble();

        System.out.print("Enter the second side of the park: ");
        double side2 = scanner.nextDouble();

        System.out.print("Enter the third side of the park: ");
        double side3 = scanner.nextDouble();

        double distance = 5000;
        double rounds = calculateRounds(side1, side2, side3, distance);
        System.out.printf("The athlete must complete %.2f rounds.%n", rounds);
    }
}
