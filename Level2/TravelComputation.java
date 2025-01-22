import java.util.Scanner;
class TravelComputation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the traveler's name: ");
        String name = input.nextLine();

        System.out.print("Enter the from city: ");
        String fromCity = input.nextLine();

        System.out.print("Enter the via city: ");
        String viaCity = input.nextLine();

        System.out.print("Enter the to city: ");
        String toCity = input.nextLine();

        System.out.print("Enter the distance from " + fromCity + " to " + viaCity + " in miles: ");
        double distanceFromToVia = input.nextDouble();

        System.out.print("Enter the distance from " + viaCity + " to " + toCity + " in miles: ");
        double distanceViaToFinalCity = input.nextDouble();

        System.out.print("Enter the time taken from " + fromCity + " to " + viaCity + " in minutes: ");
        int timeFromToVia = input.nextInt();

        System.out.print("Enter the time taken from " + viaCity + " to " + toCity + " in minutes: ");
        int timeViaToFinalCity = input.nextInt();

        double totalDistance = distanceFromToVia + distanceViaToFinalCity;
        int totalTime = timeFromToVia + timeViaToFinalCity;

        System.out.println("Traveler " + name + " traveled from " + fromCity + " to " + toCity +
                           " via " + viaCity + ". The total distance covered is " + totalDistance +
                           " miles and total time taken is " + totalTime + " minutes.");
    }
}
