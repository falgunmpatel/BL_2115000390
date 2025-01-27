import java.util.Scanner;

public class WindChillCalculator {
    public static double calculateWindChill(double temperature, double windSpeed) {
        return 35.74 + 0.6215 * temperature + (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter temperature: ");
        double temperature = scanner.nextDouble();

        System.out.print("Enter wind speed: ");
        double windSpeed = scanner.nextDouble();

        System.out.printf("Wind Chill Temperature: %.2f%n", calculateWindChill(temperature, windSpeed));
    }
}
