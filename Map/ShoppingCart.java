import java.util.*;

public class ShoppingCart {
  private Map<String, Double> productPrices = new HashMap<>();
  private Map<String, Integer> cart = new LinkedHashMap<>();

  public void addProduct(String product, double price) {
    productPrices.put(product, price);
  }

  public void addToCart(String product, int quantity) {
    if (productPrices.containsKey(product)) {
      cart.put(product, cart.getOrDefault(product, 0) + quantity);
    } else {
      System.out.println("Product not found!");
    }
  }

  public void displayCart() {
    System.out.println("Items in Cart (Order of Addition): " + cart);
  }

  public void displaySortedByPrice() {
    TreeMap<Double, String> sortedByPrice = new TreeMap<>();
    for (String product : cart.keySet()) {
      sortedByPrice.put(productPrices.get(product), product);
    }
    System.out.println("Items in Cart (Sorted by Price): " + sortedByPrice);
  }

  public static void main(String[] args) {
    ShoppingCart cart = new ShoppingCart();
    cart.addProduct("Apple", 1.0);
    cart.addProduct("Banana", 0.5);
    cart.addProduct("Cherry", 2.0);
    cart.addToCart("Apple", 3);
    cart.addToCart("Banana", 2);
    cart.addToCart("Cherry", 1);
    cart.displayCart();
    cart.displaySortedByPrice();
  }
}
