class Book {
   public String ISBN;
   protected String title;
   private String author;

   public Book(String ISBN, String title, String author) {
       this.ISBN = ISBN;
       this.title = title;
       this.author = author;
   }

   public void setAuthor(String author) {
       this.author = author;
   }

   public String getAuthor() {
       return this.author;
   }
}

class EBook extends Book {
    public EBook(String ISBN, String title, String author) {
       super(ISBN, title, author);
    }

    public void displayInfo() {
        System.out.println("*************************");
        System.out.println();

        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);

        System.out.println();
        System.out.println("*************************");
    }
}

public class BookLibrarySystem {
   public static void main(String[] args) {
       EBook myEBook = new EBook("978-3-16-148410-0", "Java Programming", "John Doe");

       myEBook.displayInfo();

       System.out.println("\nAuthor (via getter): " + myEBook.getAuthor());
       myEBook.setAuthor("Jane Doe");
       System.out.println("\nUpdated Author (via getter): " + myEBook.getAuthor());
   }
}
