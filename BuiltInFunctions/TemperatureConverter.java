import java.util.InputMismatchException;
import java.util.Scanner;

public class TemperatureConverter {
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter temperature value:");
            double temperature = scanner.nextDouble();
            System.out.println("Convert to (C/F)?");
            char choice = scanner.next().toUpperCase().charAt(0);

            if (choice == 'C') {
                System.out.println("Temperature in Celsius: " + fahrenheitToCelsius(temperature));
            } else if (choice == 'F') {
                System.out.println("Temperature in Fahrenheit: " + celsiusToFahrenheit(temperature));
            } else {
                throw new IllegalArgumentException("Invalid choice! Enter 'C' or 'F'.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a numeric value.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
