import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem {
  private String name;

  public WarehouseItem(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public abstract void displayInfo();
}

class Electronics extends WarehouseItem {
  private String brand;

  public Electronics(String brand, String name) {
    super(name);
    this.brand = brand;
  }

  public void displayInfo() {
    System.out.println("The Electronics name is " + getName() + " of brand " + brand);
  }
}

class Groceries extends WarehouseItem {
  private String expiryDate;

  public Groceries(String expiryDate, String name) {
    super(name);
    this.expiryDate = expiryDate;
  }

  public void displayInfo() {
    System.out.println("The grocery name is" + getName() + " of expiry date is " + expiryDate);
  }
}

class Furniture extends WarehouseItem {
  private String material;

  public Furniture(String name, String material) {
    super(name);
    this.material = material;
  }

  public void displayInfo() {
    System.out.println("The furniture name is " + getName() + " of material " + material);
  }
}

class Storage<T extends WarehouseItem> {
  private List<T> items = new ArrayList<>();

  public void addItem(T item) {
    items.add(item);
  }

  public T getItem(int index) {
    if (index >= 0 && index < items.size()) {
      return items.get(index);
    }
    return null;
  }

  public List<T> getAllItems() {
    return items;
  }
}

class WarehouseUtils {
  public static void displayItems(List<? extends WarehouseItem> items) {
    for (WarehouseItem item : items) {
      item.displayInfo();
    }
  }
}

public class WarehouseManagementSystem {
  public static void main(String[] args) {
    Storage<Electronics> electronicsStorage = new Storage<>();
    electronicsStorage.addItem(new Electronics("Laptop", "Dell"));
    electronicsStorage.addItem(new Electronics("Phone", "Samsung"));

    Storage<Groceries> groceriesStorage = new Storage<>();
    groceriesStorage.addItem(new Groceries("Milk", "2025-01-01"));
    groceriesStorage.addItem(new Groceries("Bread", "2025-02-10"));

    Storage<Furniture> furnitureStorage = new Storage<>();
    furnitureStorage.addItem(new Furniture("Chair", "Wood"));
    furnitureStorage.addItem(new Furniture("Table", "Metal"));

    System.out.println("Displaying Electronics:");
    WarehouseUtils.displayItems(electronicsStorage.getAllItems());

    System.out.println("\nDisplaying Groceries:");
    WarehouseUtils.displayItems(groceriesStorage.getAllItems());

    System.out.println("\nDisplaying Furniture:");
    WarehouseUtils.displayItems(furnitureStorage.getAllItems());
  }
}
