class Vehicle{
   private String ownerName;
   private String vehicleType;
   private static int registrationFee = 500;

   Vehicle(String ownerName, String vehicleType){
       this.ownerName = ownerName;
       this.vehicleType = vehicleType;
   }

   void displayVehicleDetails(){
        System.out.println("*************************");
        System.out.println();

        System.out.println("Owner of this vehicle is: " + this.ownerName);
        System.out.println("type of vehicle: " + this.vehicleType);

        System.out.println();
        System.out.println("************************");
   }

   static void updateRegistrationFee(int fee){
       registrationFee = fee;
       System.out.println("\nRegistration fee updated to:" + registrationFee);
   }
}

public class VehicleRegistration {
   public static void main(String[] args){
       Vehicle vehicle1 = new Vehicle("Owner_01", "sedan");
       Vehicle vehicle2 = new Vehicle("Owner_02", "ATV");

       vehicle1.displayVehicleDetails();
       vehicle2.displayVehicleDetails();

       Vehicle.updateRegistrationFee(750);
   }
}
