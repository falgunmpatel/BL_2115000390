import java.util.*;

class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    int totalCost;

    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        calculateCost();
    }

    void calculateCost() {
        int[] costPerDay = { 1200, 1500, 1800, 2000, 2500, 4500 };
        int totalCost = this.rentalDays * costPerDay[(int)( Math.random() * (6-0) + 1)];
        System.out.println("The total cost of rental would be: " + totalCost);
    }

}

public class CarRentalExample {
    public static void main(String []args) {
        CarRental car1 = new CarRental("customer_01", "Pagani Huayra", 1);
        CarRental car2 = new CarRental("customer_02", "Bugatti La Voiture Noire", 5);
    }
}
