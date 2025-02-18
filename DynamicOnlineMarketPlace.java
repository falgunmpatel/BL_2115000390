import java.util.*;

enum BookCategory {
  FICTION,
  NON_FICTION,
  EDUCATIONAL
}

enum ClothingCategory {
  MEN,
  WOMEN,
  KIDS
}

enum GadgetCategory {
  MOBILE,
  LAPTOP,
  ACCESSORY
}

class Product<T> {
  private String name;
  private double price;
  private T category;

  public Product(String name, double price, T category) {
    this.name = name;
    this.price = price;
    this.category = category;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

  public T getCategory() {
    return category;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void displayProduct() {
    System.out.println("Product: " + name + ", Price: $" + price + ", Category: " + category);
  }
}

class ProductCatalog<T extends Product<?>> {
  private List<T> products = new ArrayList<>();

  public void addProduct(T product) {
    products.add(product);
  }

  public List<T> getAllProducts() {
    return products;
  }
}

class ProductUtils {
  public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
    double discount = product.getPrice() * (percentage / 100);
    product.setPrice(product.getPrice() - discount);
    System.out.println("Discount applied: " + percentage + "% New Price: $" + product.getPrice());
  }

  public static void displayAllProducts(List<? extends Product<?>> products) {
    for (Product<?> product : products) {
      product.displayProduct();
    }
  }
}

public class DynamicOnlineMarketPlace {
  public static void main(String[] args) {
    Product<BookCategory> book1 = new Product<>("The Alchemist", 15.99, BookCategory.FICTION);
    Product<BookCategory> book2 =
        new Product<>("Physics for Engineers", 40.50, BookCategory.EDUCATIONAL);

    Product<ClothingCategory> shirt = new Product<>("Men's T-Shirt", 25.00, ClothingCategory.MEN);
    Product<ClothingCategory> dress = new Product<>("Women's Dress", 60.00, ClothingCategory.WOMEN);

    Product<GadgetCategory> phone = new Product<>("Smartphone", 799.99, GadgetCategory.MOBILE);
    Product<GadgetCategory> laptop = new Product<>("Gaming Laptop", 1299.99, GadgetCategory.LAPTOP);

    ProductCatalog<Product<BookCategory>> bookCatalog = new ProductCatalog<>();
    bookCatalog.addProduct(book1);
    bookCatalog.addProduct(book2);

    ProductCatalog<Product<ClothingCategory>> clothingCatalog = new ProductCatalog<>();
    clothingCatalog.addProduct(shirt);
    clothingCatalog.addProduct(dress);

    ProductCatalog<Product<GadgetCategory>> gadgetCatalog = new ProductCatalog<>();
    gadgetCatalog.addProduct(phone);
    gadgetCatalog.addProduct(laptop);

    System.out.println("\nApplying Discounts:");
    ProductUtils.applyDiscount(book1, 10);
    ProductUtils.applyDiscount(phone, 5);

    System.out.println("\nAll Books:");
    ProductUtils.displayAllProducts(bookCatalog.getAllProducts());

    System.out.println("\nAll Clothing:");
    ProductUtils.displayAllProducts(clothingCatalog.getAllProducts());

    System.out.println("\nAll Gadgets:");
    ProductUtils.displayAllProducts(gadgetCatalog.getAllProducts());
  }
}
