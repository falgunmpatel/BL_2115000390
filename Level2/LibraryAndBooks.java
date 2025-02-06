import java.util.*;

class Library {
    private String libraryName;
    private List<Book> books;

    Library(String libraryName) {
        this.libraryName = libraryName;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        if (book == null) {
            System.out.println("Cannot add a null book!");
            return;
        }
        this.books.add(book);
        System.out.printf("Book \"%s\" added to library \"%s\"%n", book.getTitle(), this.libraryName);
    }

    public void printLibraryInfo() {
        System.out.println("\n********* Library Info **********");
        System.out.println("Library Name: " + this.libraryName);

        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("Books: " + books);
        }

        System.out.println("*********************************\n");
    }
}

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    @Override
    public String toString() {
        return String.format("\"%s\" by %s", title, author);
    }
}

public class LibraryAndBooks {
    public static void main(String[] args) {
        Library library1 = new Library("Library_01");
        Library library2 = new Library("Library_02");

        Book book1 = new Book("Book_01", "Author_01");
        Book book2 = new Book("Book_02", "Author_02");
        Book book3 = new Book("Book_03", "Author_03");

        book1.toString();

        library1.printLibraryInfo();
        library1.addBook(book1);
        library1.addBook(book2);
        library1.printLibraryInfo();

        library2.addBook(book3);
        library2.printLibraryInfo();
    }
}

