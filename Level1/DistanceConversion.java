import java.util.Scanner;
class DistanceConversion {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the distance in feet: ");
        double distanceInFeet = input.nextDouble();

        double distanceInYards = distanceInFeet / 3;
        double distanceInMiles = distanceInYards / 1760;

        System.out.println("The distance is " + distanceInYards + " yards and " + distanceInMiles + " miles for the given " + distanceInFeet + " feet.");
    }
}
