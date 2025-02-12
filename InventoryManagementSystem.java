import java.util.Scanner;

class Item {
  String itemName;
  int itemId;
  int quantity;
  double price;
  Item next;

  public Item(String itemName, int itemId, int quantity, double price) {
    this.itemName = itemName;
    this.itemId = itemId;
    this.quantity = quantity;
    this.price = price;
    this.next = null;
  }
}

class Inventory {
  private Item head;

  public void addAtBeginning(String itemName, int itemId, int quantity, double price) {
    Item newItem = new Item(itemName, itemId, quantity, price);
    newItem.next = head;
    head = newItem;
  }

  public void addAtEnd(String itemName, int itemId, int quantity, double price) {
    Item newItem = new Item(itemName, itemId, quantity, price);
    if (head == null) {
      head = newItem;
      return;
    }
    Item temp = head;
    while (temp.next != null) {
      temp = temp.next;
    }
    temp.next = newItem;
  }

  public void addAtPosition(String itemName, int itemId, int quantity, double price, int position) {
    Item newItem = new Item(itemName, itemId, quantity, price);
    if (position <= 0) {
      System.out.println("Invalid position!");
      return;
    }
    if (position == 1) {
      newItem.next = head;
      head = newItem;
      return;
    }
    Item temp = head;
    for (int i = 1; temp != null && i < position - 1; i++) {
      temp = temp.next;
    }
    if (temp == null) {
      System.out.println("Position out of range!");
      return;
    }
    newItem.next = temp.next;
    temp.next = newItem;
  }

  public void removeItem(int itemId) {
    if (head == null) {
      System.out.println("Inventory is empty.");
      return;
    }
    if (head.itemId == itemId) {
      head = head.next;
      System.out.println("Item removed successfully.");
      return;
    }
    Item temp = head, prev = null;
    while (temp != null && temp.itemId != itemId) {
      prev = temp;
      temp = temp.next;
    }
    if (temp == null) {
      System.out.println("Item not found.");
      return;
    }
    prev.next = temp.next;
    System.out.println("Item removed successfully.");
  }

  public void updateQuantity(int itemId, int newQuantity) {
    Item temp = head;
    while (temp != null) {
      if (temp.itemId == itemId) {
        temp.quantity = newQuantity;
        System.out.println("Quantity updated successfully.");
        return;
      }
      temp = temp.next;
    }
    System.out.println("Item not found.");
  }

  public void searchById(int itemId) {
    Item temp = head;
    while (temp != null) {
      if (temp.itemId == itemId) {
        System.out.println(
            "Item Found: ID="
                + temp.itemId
                + ", Name="
                + temp.itemName
                + ", Quantity="
                + temp.quantity
                + ", Price="
                + temp.price);
        return;
      }
      temp = temp.next;
    }
    System.out.println("Item not found.");
  }

  public void searchByName(String itemName) {
    Item temp = head;
    while (temp != null) {
      if (temp.itemName.equalsIgnoreCase(itemName)) {
        System.out.println(
            "Item Found: ID="
                + temp.itemId
                + ", Name="
                + temp.itemName
                + ", Quantity="
                + temp.quantity
                + ", Price="
                + temp.price);
        return;
      }
      temp = temp.next;
    }
    System.out.println("Item not found.");
  }

  public void calculateTotalValue() {
    double totalValue = 0;
    Item temp = head;
    while (temp != null) {
      totalValue += temp.price * temp.quantity;
      temp = temp.next;
    }
    System.out.println("Total Inventory Value: $" + totalValue);
  }

  public void displayAll() {
    if (head == null) {
      System.out.println("Inventory is empty.");
      return;
    }
    Item temp = head;
    while (temp != null) {
      System.out.println(
          "ID="
              + temp.itemId
              + ", Name="
              + temp.itemName
              + ", Quantity="
              + temp.quantity
              + ", Price=$"
              + temp.price);
      temp = temp.next;
    }
  }
}

public class InventoryManagementSystem {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Inventory inventory = new Inventory();

    while (true) {
      System.out.println("\nInventory Management System");
      System.out.println("1. Add Item at Beginning");
      System.out.println("2. Add Item at End");
      System.out.println("3. Add Item at Specific Position");
      System.out.println("4. Remove Item by ID");
      System.out.println("5. Update Quantity");
      System.out.println("6. Search Item by ID");
      System.out.println("7. Search Item by Name");
      System.out.println("8. Display All Items");
      System.out.println("9. Calculate Total Inventory Value");
      System.out.println("10. Exit");
      System.out.print("Enter your choice: ");

      int choice = scanner.nextInt();
      switch (choice) {
        case 1:
          System.out.print("Enter Item Name: ");
          scanner.nextLine();
          String name1 = scanner.nextLine();
          System.out.print("Enter Item ID: ");
          int id1 = scanner.nextInt();
          System.out.print("Enter Quantity: ");
          int qty1 = scanner.nextInt();
          System.out.print("Enter Price: ");
          double price1 = scanner.nextDouble();
          inventory.addAtBeginning(name1, id1, qty1, price1);
          break;
        case 2:
          System.out.print("Enter Item Name: ");
          scanner.nextLine();
          String name2 = scanner.nextLine();
          System.out.print("Enter Item ID: ");
          int id2 = scanner.nextInt();
          System.out.print("Enter Quantity: ");
          int qty2 = scanner.nextInt();
          System.out.print("Enter Price: ");
          double price2 = scanner.nextDouble();
          inventory.addAtEnd(name2, id2, qty2, price2);
          break;
        case 3:
          System.out.print("Enter Item Name: ");
          scanner.nextLine();
          String name3 = scanner.nextLine();
          System.out.print("Enter Item ID: ");
          int id3 = scanner.nextInt();
          System.out.print("Enter Quantity: ");
          int qty3 = scanner.nextInt();
          System.out.print("Enter Price: ");
          double price3 = scanner.nextDouble();
          System.out.print("Enter Position: ");
          int position = scanner.nextInt();
          inventory.addAtPosition(name3, id3, qty3, price3, position);
          break;
        case 4:
          System.out.print("Enter Item ID to remove: ");
          int removeId = scanner.nextInt();
          inventory.removeItem(removeId);
          break;
        case 5:
          System.out.print("Enter Item ID to update: ");
          int updateId = scanner.nextInt();
          System.out.print("Enter new Quantity: ");
          int newQty = scanner.nextInt();
          inventory.updateQuantity(updateId, newQty);
          break;
        case 6:
          System.out.print("Enter Item ID to search: ");
          int searchId = scanner.nextInt();
          inventory.searchById(searchId);
          break;
        case 7:
          System.out.print("Enter Item Name to search: ");
          scanner.nextLine();
          String searchName = scanner.nextLine();
          inventory.searchByName(searchName);
          break;
        case 8:
          inventory.displayAll();
          break;
        case 9:
          inventory.calculateTotalValue();
          break;
        case 10:
          System.out.println("Exiting...");
          scanner.close();
          return;
        default:
          System.out.println("Invalid choice! Try again.");
      }
    }
  }
}
