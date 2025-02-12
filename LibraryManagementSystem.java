import java.util.Scanner;

class Book {
  String title;
  String author;
  String genre;
  int bookId;
  boolean isAvailable;
  Book next;
  Book prev;

  public Book(String title, String author, String genre, int bookId, boolean isAvailable) {
    this.title = title;
    this.author = author;
    this.genre = genre;
    this.bookId = bookId;
    this.isAvailable = isAvailable;
    this.next = null;
    this.prev = null;
  }
}

class Library {
  private Book head;
  private Book tail;

  public void addAtBeginning(
      String title, String author, String genre, int bookId, boolean isAvailable) {
    Book newBook = new Book(title, author, genre, bookId, isAvailable);
    if (head == null) {
      head = tail = newBook;
    } else {
      newBook.next = head;
      head.prev = newBook;
      head = newBook;
    }
  }

  public void addAtEnd(String title, String author, String genre, int bookId, boolean isAvailable) {
    Book newBook = new Book(title, author, genre, bookId, isAvailable);
    if (head == null) {
      head = tail = newBook;
    } else {
      tail.next = newBook;
      newBook.prev = tail;
      tail = newBook;
    }
  }

  public void addAtPosition(
      String title, String author, String genre, int bookId, boolean isAvailable, int position) {
    if (position <= 0) {
      System.out.println("Invalid position!");
      return;
    }
    Book newBook = new Book(title, author, genre, bookId, isAvailable);
    if (position == 1) {
      addAtBeginning(title, author, genre, bookId, isAvailable);
      return;
    }
    Book temp = head;
    for (int i = 1; temp != null && i < position - 1; i++) {
      temp = temp.next;
    }
    if (temp == null) {
      System.out.println("Position out of range!");
      return;
    }
    newBook.next = temp.next;
    newBook.prev = temp;
    if (temp.next != null) {
      temp.next.prev = newBook;
    }
    temp.next = newBook;
    if (temp == tail) {
      tail = newBook;
    }
  }

  public void removeBook(int bookId) {
    if (head == null) {
      System.out.println("Library is empty.");
      return;
    }
    if (head.bookId == bookId) {
      head = head.next;
      if (head != null) {
        head.prev = null;
      } else {
        tail = null;
      }
      System.out.println("Book removed successfully.");
      return;
    }
    Book temp = head;
    while (temp != null && temp.bookId != bookId) {
      temp = temp.next;
    }
    if (temp == null) {
      System.out.println("Book not found.");
      return;
    }
    if (temp.next != null) {
      temp.next.prev = temp.prev;
    }
    if (temp.prev != null) {
      temp.prev.next = temp.next;
    }
    if (temp == tail) {
      tail = temp.prev;
    }
    System.out.println("Book removed successfully.");
  }

  public void searchByTitle(String title) {
    Book temp = head;
    while (temp != null) {
      if (temp.title.equalsIgnoreCase(title)) {
        System.out.println(
            "Book Found: ID="
                + temp.bookId
                + ", Title="
                + temp.title
                + ", Author="
                + temp.author
                + ", Genre="
                + temp.genre
                + ", Available="
                + temp.isAvailable);
        return;
      }
      temp = temp.next;
    }
    System.out.println("Book not found.");
  }

  public void searchByAuthor(String author) {
    Book temp = head;
    while (temp != null) {
      if (temp.author.equalsIgnoreCase(author)) {
        System.out.println(
            "Book Found: ID="
                + temp.bookId
                + ", Title="
                + temp.title
                + ", Genre="
                + temp.genre
                + ", Available="
                + temp.isAvailable);
      }
      temp = temp.next;
    }
  }

  public void updateAvailability(int bookId, boolean availability) {
    Book temp = head;
    while (temp != null) {
      if (temp.bookId == bookId) {
        temp.isAvailable = availability;
        System.out.println("Book availability updated.");
        return;
      }
      temp = temp.next;
    }
    System.out.println("Book not found.");
  }

  public void displayForward() {
    if (head == null) {
      System.out.println("Library is empty.");
      return;
    }
    Book temp = head;
    while (temp != null) {
      System.out.println(
          "ID="
              + temp.bookId
              + ", Title="
              + temp.title
              + ", Author="
              + temp.author
              + ", Genre="
              + temp.genre
              + ", Available="
              + temp.isAvailable);
      temp = temp.next;
    }
  }

  public void displayReverse() {
    if (tail == null) {
      System.out.println("Library is empty.");
      return;
    }
    Book temp = tail;
    while (temp != null) {
      System.out.println(
          "ID="
              + temp.bookId
              + ", Title="
              + temp.title
              + ", Author="
              + temp.author
              + ", Genre="
              + temp.genre
              + ", Available="
              + temp.isAvailable);
      temp = temp.prev;
    }
  }

  public int countBooks() {
    int count = 0;
    Book temp = head;
    while (temp != null) {
      count++;
      temp = temp.next;
    }
    return count;
  }
}

public class LibraryManagementSystem {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Library library = new Library();

    while (true) {
      System.out.println("\nLibrary Management System");
      System.out.println("1. Add Book at Beginning");
      System.out.println("2. Add Book at End");
      System.out.println("3. Add Book at Specific Position");
      System.out.println("4. Remove Book by ID");
      System.out.println("5. Search Book by Title");
      System.out.println("6. Search Book by Author");
      System.out.println("7. Update Book Availability");
      System.out.println("8. Display All Books (Forward)");
      System.out.println("9. Display All Books (Reverse)");
      System.out.println("10. Count Total Books");
      System.out.println("11. Exit");
      System.out.print("Enter your choice: ");

      int choice = scanner.nextInt();
      switch (choice) {
        case 1:
        case 2:
        case 3:
          System.out.print("Enter Book Title: ");
          scanner.nextLine();
          String title = scanner.nextLine();
          System.out.print("Enter Author: ");
          String author = scanner.nextLine();
          System.out.print("Enter Genre: ");
          String genre = scanner.nextLine();
          System.out.print("Enter Book ID: ");
          int bookId = scanner.nextInt();
          System.out.print("Is Available (true/false): ");
          boolean available = scanner.nextBoolean();
          if (choice == 1) library.addAtBeginning(title, author, genre, bookId, available);
          else if (choice == 2) library.addAtEnd(title, author, genre, bookId, available);
          else {
            System.out.print("Enter Position: ");
            int position = scanner.nextInt();
            library.addAtPosition(title, author, genre, bookId, available, position);
          }
          break;
        case 4:
          System.out.print("Enter Book ID to remove: ");
          int removeId = scanner.nextInt();
          library.removeBook(removeId);
          break;
        case 5:
          System.out.print("Enter Book Title to search: ");
          scanner.nextLine();
          library.searchByTitle(scanner.nextLine());
          break;
        case 6:
          System.out.print("Enter Author Name to search: ");
          scanner.nextLine();
          library.searchByAuthor(scanner.nextLine());
          break;
        case 7:
          System.out.print("Enter Book ID to update: ");
          int updateId = scanner.nextInt();
          System.out.print("Is Available (true/false): ");
          library.updateAvailability(updateId, scanner.nextBoolean());
          break;
        case 8:
          library.displayForward();
          break;
        case 9:
          library.displayReverse();
          break;
        case 10:
          System.out.println("Total Books: " + library.countBooks());
          break;
        case 11:
          System.out.println("Exiting...");
          scanner.close();
          return;
        default:
          System.out.println("Invalid choice! Try again.");
      }
    }
  }
}
