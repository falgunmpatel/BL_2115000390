import java.util.*;

class Book {
    String title;
    String author;
    int price;
    String availability;

    Book(String title, String author, int price, String availability) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.availability = availability;
    }

    void borrowBook() {
        if(this.availability.equals("available")) {
            this.availability = "not available";
            System.out.println("You have successfully borrowed the book " + this.title);
        } else {
            System.out.println("Sorry, The book with title " + this.title +  " is not available!");
        }
    }
}

public class LibraryBookExample {
    public static void main (String []args) {
        Book book1 = new Book("Book_01", "Author_01", 420, "available");
        Book book2 = new Book("Book_02", "Author_02", 380, "not available");

        book1.borrowBook();
        book1.borrowBook();
        book2.borrowBook();
    }
}
