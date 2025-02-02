import java.util.*;

class Book {
    String title;
    String author;
    int price;

    Book() {
	this.title = "My_Book";
	this.author = "Author_01";
	this.price = 150;
    }

    Book (String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price  = price;
    }

    void displayBook() {

	System.out.println("***********************");	
        System.out.println();
	
	System.out.println("Book details:");
        System.out.println("Title: " + this.title);
        System.out.println("Author:" + this.author);
        System.out.println("Price: " + this.price);
        
        System.out.println();
	System.out.println("***********************");
    }
}

public class BookExample {
    public static void main(String []args) {
	Book book1 = new Book();
        Book book2 = new Book("Programming in Java", "Falgun_Patel", 259);
        book1.displayBook();
        book2.displayBook();
    }
}
