import java.util.ArrayList;
import java.util.List;

abstract class Vehicle {
  private String vehicleId;
  private String driverName;
  private double ratePerKm;

  public Vehicle(String vehicleId, String driverName, double ratePerKm) {
    this.vehicleId = vehicleId;
    this.driverName = driverName;
    this.ratePerKm = ratePerKm;
  }

  public String getVehicleId() {
    return vehicleId;
  }

  public String getDriverName() {
    return driverName;
  }

  public double getRatePerKm() {
    return ratePerKm;
  }

  public void displayDetails() {
    System.out.println("Vehicle ID: " + vehicleId);
    System.out.println("Driver: " + driverName);
    System.out.println("Rate per km: " + ratePerKm);
  }

  public abstract double calculateFare(double distance);
}

interface GPS {
  void getCurrentLocation();

  void updateLocation(String newLocation);
}

class Car extends Vehicle implements GPS {
  private String location;

  public Car(String vehicleId, String driverName, double ratePerKm, String location) {
    super(vehicleId, driverName, ratePerKm);
    this.location = location;
  }

  @Override
  public double calculateFare(double distance) {
    return getRatePerKm() * distance;
  }

  @Override
  public void getCurrentLocation() {
    System.out.println("Current Location: " + location);
  }

  @Override
  public void updateLocation(String newLocation) {
    this.location = newLocation;
    System.out.println("Updated Location: " + location);
  }
}

class Bike extends Vehicle implements GPS {
  private String location;

  public Bike(String vehicleId, String driverName, double ratePerKm, String location) {
    super(vehicleId, driverName, ratePerKm);
    this.location = location;
  }

  @Override
  public double calculateFare(double distance) {
    return getRatePerKm() * distance * 0.9;
  }

  @Override
  public void getCurrentLocation() {
    System.out.println("Current Location: " + location);
  }

  @Override
  public void updateLocation(String newLocation) {
    this.location = newLocation;
    System.out.println("Updated Location: " + location);
  }
}

class Auto extends Vehicle implements GPS {
  private String location;

  public Auto(String vehicleId, String driverName, double ratePerKm, String location) {
    super(vehicleId, driverName, ratePerKm);
    this.location = location;
  }

  @Override
  public double calculateFare(double distance) {
    return getRatePerKm() * distance * 1.1;
  }

  @Override
  public void getCurrentLocation() {
    System.out.println("Current Location: " + location);
  }

  @Override
  public void updateLocation(String newLocation) {
    this.location = newLocation;
    System.out.println("Updated Location: " + location);
  }
}

public class RideHailingApplication {
  public static void main(String[] args) {
    List<Vehicle> rides = new ArrayList<>();

    Car car1 = new Car("C101", "John", 15.0, "Downtown");
    Bike bike1 = new Bike("B202", "Emma", 8.0, "Uptown");
    Auto auto1 = new Auto("A303", "Mike", 10.0, "City Center");

    rides.add(car1);
    rides.add(bike1);
    rides.add(auto1);

    double distance = 10;

    for (Vehicle ride : rides) {
      ride.displayDetails();
      System.out.println("Fare for " + distance + " km: " + ride.calculateFare(distance));
      if (ride instanceof GPS) {
        ((GPS) ride).getCurrentLocation();
      }
    }
  }
}
