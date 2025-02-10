import java.util.ArrayList;
import java.util.List;

abstract class Product {
  private String productId;
  private String name;
  private double price;

  public Product(String productId, String name, double price) {
    this.productId = productId;
    this.name = name;
    this.price = price;
  }

  public String getProductId() {
    return productId;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public abstract double calculateDiscount();

  public void displayDetails() {
    System.out.println("Product ID: " + productId);
    System.out.println("Name: " + name);
    System.out.println("Price: " + price);
    System.out.println("Discount: " + calculateDiscount());
  }
}

interface Taxable {
  double calculateTax();

  String getTaxDetails();
}

class Electronics extends Product implements Taxable {
  private static final double TAX_RATE = 0.15;

  public Electronics(String productId, String name, double price) {
    super(productId, name, price);
  }

  @Override
  public double calculateDiscount() {
    return getPrice() * 0.10;
  }

  @Override
  public double calculateTax() {
    return getPrice() * TAX_RATE;
  }

  @Override
  public String getTaxDetails() {
    return "Tax Rate: 15%";
  }
}

class Clothing extends Product implements Taxable {
  private static final double TAX_RATE = 0.05;

  public Clothing(String productId, String name, double price) {
    super(productId, name, price);
  }

  @Override
  public double calculateDiscount() {
    return getPrice() * 0.20;
  }

  @Override
  public double calculateTax() {
    return getPrice() * TAX_RATE;
  }

  @Override
  public String getTaxDetails() {
    return "Tax Rate: 5%";
  }
}

class Groceries extends Product {
  public Groceries(String productId, String name, double price) {
    super(productId, name, price);
  }

  @Override
  public double calculateDiscount() {
    return getPrice() * 0.05;
  }
}

public class ECommercePlatform {
  public static void main(String[] args) {
    List<Product> products = new ArrayList<>();

    Electronics prod1 = new Electronics("E101", "Laptop", 800);
    Clothing prod2 = new Clothing("C102", "T-Shirt", 50);
    Groceries prod3 = new Groceries("G103", "Apples", 10);

    products.add(prod1);
    products.add(prod2);
    products.add(prod3);

    for (Product prod : products) {
      prod.displayDetails();
      if (prod instanceof Taxable) {
        System.out.println(((Taxable) prod).getTaxDetails());
      }
      double finalPrice =
          prod.getPrice()
              + ((prod instanceof Taxable) ? ((Taxable) prod).calculateTax() : 0)
              - prod.calculateDiscount();
      System.out.println("Final Price: " + finalPrice);
    }
  }
}
