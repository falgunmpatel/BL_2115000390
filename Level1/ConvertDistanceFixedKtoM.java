import java.util.Scanner;
class ConvertDistanceFixedKtoM {
    public static void main(String[] args) {
        double distanceInKilometers = 10.8;
        double conversionFactor = 1.6;
        double distanceInMiles = distanceInKilometers / conversionFactor;

        System.out.println("The distance " + distanceInKilometers + " km in miles is " + distanceInMiles + ".");
    }
}
