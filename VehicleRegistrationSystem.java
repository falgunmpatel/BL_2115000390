class Vehicle {
    private static double registrationFee = 500.0;
    private final String registrationNumber;
    private String ownerName;
    private String vehicleType;

    Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    void displayRegistrationInfo() {
        System.out.println("*********************");
        System.out.println();

        System.out.println("Vehicle Registration Info: ");
        System.out.println("Owner Name: " + this.ownerName);
        System.out.println("Vehicle Type: " + this.vehicleType);
        System.out.println("Registration Number: " + this.registrationNumber);
        System.out.println("Registration Fee: $" + registrationFee);

        System.out.println();
        System.out.println("*********************");
    }

    String getOwnerName() {
        return ownerName;
    }

    String getVehicleType() {
        return vehicleType;
    }

    String getRegistrationNumber() {
        return registrationNumber;
    }
}

public class VehicleRegistrationSystem {
    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("Alice", "Car", "ABC123");
        Vehicle vehicle2 = new Vehicle("Bob", "Motorcycle", "XYZ456");

        Vehicle.updateRegistrationFee(600.0);

        if (vehicle1 instanceof Vehicle) {
            vehicle1.displayRegistrationInfo();
        }

        if (vehicle2 instanceof Vehicle) {
            vehicle2.displayRegistrationInfo();
        }
    }
}

