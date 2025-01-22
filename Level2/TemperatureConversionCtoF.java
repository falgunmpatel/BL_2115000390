import java.util.Scanner;
class TemperatureConversionCtoF {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the temperature in Celsius: ");
        double celsius = input.nextDouble();

        double fahrenheitResult = (celsius * 9 / 5) + 32;

        System.out.println("The " + celsius + " celsius is " + fahrenheitResult + " fahrenheit.");
    }
}
