import java.util.Scanner;
class VolumeOfEarth {
    public static void main(String[] args) {
        double radiusKm = 6378;
        double conversionFactor = 1.6;
        double volumeKm3 = (4.0 / 3) * Math.PI * Math.pow(radiusKm, 3);
        double volumeMiles3 = volumeKm3 / Math.pow(conversionFactor, 3);

        System.out.println("The volume of Earth in cubic kilometers is " + volumeKm3 + 
                           " and cubic miles is " + volumeMiles3 + ".");
    }
}
