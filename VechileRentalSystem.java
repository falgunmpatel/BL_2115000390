import java.util.ArrayList;
import java.util.List;

abstract class Vehicle {
  private String vehicleNumber;
  private String type;
  private double rentalRate;

  public Vehicle(String vehicleNumber, String type, double rentalRate) {
    this.vehicleNumber = vehicleNumber;
    this.type = type;
    this.rentalRate = rentalRate;
  }

  public String getVehicleNumber() {
    return vehicleNumber;
  }

  public String getType() {
    return type;
  }

  public double getRentalRate() {
    return rentalRate;
  }

  public void setVehicleNumber(String vehicleNumber) {
    this.vehicleNumber = vehicleNumber;
  }

  public void setType(String Type) {
    this.type = Type;
  }

  public void setRentalRate(double rentalRate) {
    this.rentalRate = rentalRate;
  }

  public abstract double calculateRentalCost(int days);

  public void displayDetails() {
    System.out.println("Vehicle Number: " + vehicleNumber);
    System.out.println("Type: " + type);
    System.out.println("Rental Rate: " + rentalRate);
  }
}

interface Insurable {
  double calculateInsurance();

  String getInsuranceDetails();
}

class Car extends Vehicle implements Insurable {
  private static final double INSURANCE_RATE = 0.05;

  public Car(String vehicleNumber, double rentalRate) {
    super(vehicleNumber, "Car", rentalRate);
  }

  @Override
  public double calculateRentalCost(int days) {
    return getRentalRate() * days;
  }

  @Override
  public double calculateInsurance() {
    return getRentalRate() * INSURANCE_RATE;
  }

  @Override
  public String getInsuranceDetails() {
    return "Insurance Rate: 5%";
  }
}

class Bike extends Vehicle {
  public Bike(String vehicleNumber, double rentalRate) {
    super(vehicleNumber, "Bike", rentalRate);
  }

  @Override
  public double calculateRentalCost(int days) {
    return getRentalRate() * days * 0.9; // 10% discount on rental cost
  }
}

class Truck extends Vehicle implements Insurable {
  private static final double INSURANCE_RATE = 0.10;

  public Truck(String vehicleNumber, double rentalRate) {
    super(vehicleNumber, "Truck", rentalRate);
  }

  @Override
  public double calculateRentalCost(int days) {
    return getRentalRate() * days * 1.2; // 20% surcharge on rental cost
  }

  @Override
  public double calculateInsurance() {
    return getRentalRate() * INSURANCE_RATE;
  }

  @Override
  public String getInsuranceDetails() {
    return "Insurance Rate: 10%";
  }
}

public class VechileRentalSystem {
  public static void main(String[] args) {
    List<Vehicle> vehicles = new ArrayList<>();

    Car car1 = new Car("CAR123", 50);
    Bike bike1 = new Bike("BIKE456", 20);
    Truck truck1 = new Truck("TRUCK789", 100);

    vehicles.add(car1);
    vehicles.add(bike1);
    vehicles.add(truck1);

    for (Vehicle vehicle : vehicles) {
      vehicle.displayDetails();
      int rentalDays = 5;
      System.out.println(
          "Rental Cost for " + rentalDays + " days: " + vehicle.calculateRentalCost(rentalDays));
      if (vehicle instanceof Insurable) {
        System.out.println(((Insurable) vehicle).getInsuranceDetails());
        System.out.println("Insurance Cost: " + ((Insurable) vehicle).calculateInsurance());
      }
    }
  }
}
