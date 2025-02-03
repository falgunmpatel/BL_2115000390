import java.util.*;

class Book {
    private static String libraryName= "Library_645";
    private String title;
    private String author;
    private final long isbn;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isbn = (long) (Math.random() * Math.pow(10,12));
    }

    static String displayLibraryName() {
       return libraryName;
    }

    void displayBookInfo() {
        System.out.println("*********************");
        System.out.println();

        System.out.println("Book Info: ");
        System.out.println("Title: " +  this.title);
        System.out.println("Author: " + this.author);
        System.out.println("ISBN: " + this.isbn);

        System.out.println();
        System.out.println("*********************");
    }
}

public class LibraryManagementSystem {
    public static void main(String []args) {
        Book book = new Book("Title_01","Author_01");
        System.out.printf("\nLibrary Name: %s\n", Book.displayLibraryName());
        if (book instanceof Book){
            System.out.print("\nbook is an instance of Book!!\n");
            book.displayBookInfo();
        }
    }
}
