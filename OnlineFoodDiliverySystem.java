import java.util.ArrayList;
import java.util.List;

abstract class FoodItem {
  private String itemName;
  private double price;
  private int quantity;

  public FoodItem(String itemName, double price, int quantity) {
    this.itemName = itemName;
    this.price = price;
    this.quantity = quantity;
  }

  public String getItemName() {
    return itemName;
  }

  public double getPrice() {
    return price;
  }

  public int getQuantity() {
    return quantity;
  }

  public void displayDetails() {
    System.out.println("Item: " + itemName);
    System.out.println("Price: " + price);
    System.out.println("Quantity: " + quantity);
  }

  public abstract double calculateTotalPrice();
}

interface Discountable {
  void applyDiscount(double percentage);

  double getDiscountDetails();
}

class VegItem extends FoodItem implements Discountable {
  private double discount = 0;

  public VegItem(String itemName, double price, int quantity) {
    super(itemName, price, quantity);
  }

  @Override
  public double calculateTotalPrice() {
    return (getPrice() * getQuantity()) - discount;
  }

  @Override
  public void applyDiscount(double percentage) {
    discount = (getPrice() * getQuantity()) * (percentage / 100);
  }

  @Override
  public double getDiscountDetails() {
    return discount;
  }
}

class NonVegItem extends FoodItem implements Discountable {
  private double discount = 0;
  private static final double ADDITIONAL_CHARGE = 10;

  public NonVegItem(String itemName, double price, int quantity) {
    super(itemName, price, quantity);
  }

  @Override
  public double calculateTotalPrice() {
    return (getPrice() * getQuantity()) + ADDITIONAL_CHARGE - discount;
  }

  @Override
  public void applyDiscount(double percentage) {
    discount = (getPrice() * getQuantity()) * (percentage / 100);
  }

  @Override
  public double getDiscountDetails() {
    return discount;
  }
}

public class OnlineFoodDiliverySystem {
  public static void main(String[] args) {
    List<FoodItem> order = new ArrayList<>();

    VegItem vegBurger = new VegItem("Veg Burger", 5.99, 2);
    NonVegItem chickenPizza = new NonVegItem("Chicken Pizza", 12.99, 1);

    vegBurger.applyDiscount(10);
    chickenPizza.applyDiscount(5);

    order.add(vegBurger);
    order.add(chickenPizza);

    for (FoodItem item : order) {
      item.displayDetails();
      System.out.println("Total Price: " + item.calculateTotalPrice());
      if (item instanceof Discountable) {
        System.out.println("Discount Applied: " + ((Discountable) item).getDiscountDetails());
      }
    }
  }
}
