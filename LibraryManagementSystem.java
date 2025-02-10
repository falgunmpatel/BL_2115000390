import java.util.ArrayList;
import java.util.List;

abstract class LibraryItem {
  private String itemId;
  private String title;
  private String author;

  public LibraryItem(String itemId, String title, String author) {
    this.itemId = itemId;
    this.title = title;
    this.author = author;
  }

  public String getItemId() {
    return itemId;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public void setItemId(String itemId) {
    this.itemId = itemId;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public void displayDetails() {
    System.out.println("Item ID: " + itemId);
    System.out.println("Title: " + title);
    System.out.println("Author: " + author);
  }

  public abstract int getLoanDuration();
}

interface Reservable {
  void reserveItem();

  boolean checkAvailability();
}

class Book extends LibraryItem implements Reservable {
  public Book(String itemId, String title, String author) {
    super(itemId, title, author);
  }

  @Override
  public int getLoanDuration() {
    return 14; // 14 days loan period
  }

  @Override
  public void reserveItem() {
    System.out.println("Book reserved: " + getTitle());
  }

  @Override
  public boolean checkAvailability() {
    return true;
  }
}

class Magazine extends LibraryItem {
  public Magazine(String itemId, String title, String author) {
    super(itemId, title, author);
  }

  @Override
  public int getLoanDuration() {
    return 7;
  }
}

class DVD extends LibraryItem implements Reservable {
  public DVD(String itemId, String title, String author) {
    super(itemId, title, author);
  }

  @Override
  public int getLoanDuration() {
    return 5;
  }

  @Override
  public void reserveItem() {
    System.out.println("DVD reserved: " + getTitle());
  }

  @Override
  public boolean checkAvailability() {
    return false;
  }
}

public class LibraryManagementSystem {
  public static void main(String[] args) {
    List<LibraryItem> items = new ArrayList<>();

    Book book1 = new Book("B101", "The Great Gatsby", "F. Scott Fitzgerald");
    Magazine mag1 = new Magazine("M202", "National Geographic", "Various");
    DVD dvd1 = new DVD("D303", "Inception", "Christopher Nolan");

    items.add(book1);
    items.add(mag1);
    items.add(dvd1);

    for (LibraryItem item : items) {
      item.displayDetails();
      System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
      if (item instanceof Reservable) {
        ((Reservable) item).reserveItem();
        System.out.println("Availability: " + ((Reservable) item).checkAvailability());
      }
    }
  }
}
