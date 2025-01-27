import java.util.Scanner;

public class TrigonometricFunctions {
    public static double[] calculateTrigonometricFunctions(double angle) {
        double radians = Math.toRadians(angle);
        return new double[] {Math.sin(radians), Math.cos(radians), Math.tan(radians)};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter angle in degrees: ");
        double angle = scanner.nextDouble();

        double[] result = calculateTrigonometricFunctions(angle);
        System.out.printf("Sine: %.2f, Cosine: %.2f, Tangent: %.2f%n", result[0], result[1], result[2]);
    }
}
