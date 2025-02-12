import java.util.Scanner;

class Movie {
  String title;
  String director;
  int year;
  double rating;
  Movie next, prev;

  public Movie(String title, String director, int year, double rating) {
    this.title = title;
    this.director = director;
    this.year = year;
    this.rating = rating;
    this.next = this.prev = null;
  }
}

class MovieList {
  private Movie head, tail;

  public void addAtBeginning(String title, String director, int year, double rating) {
    Movie newMovie = new Movie(title, director, year, rating);
    if (head == null) {
      head = tail = newMovie;
    } else {
      newMovie.next = head;
      head.prev = newMovie;
      head = newMovie;
    }
  }

  public void addAtEnd(String title, String director, int year, double rating) {
    Movie newMovie = new Movie(title, director, year, rating);
    if (tail == null) {
      head = tail = newMovie;
    } else {
      tail.next = newMovie;
      newMovie.prev = tail;
      tail = newMovie;
    }
  }

  public void addAtPosition(String title, String director, int year, double rating, int position) {
    if (position <= 0) {
      System.out.println("Invalid position!");
      return;
    }
    Movie newMovie = new Movie(title, director, year, rating);
    if (position == 1) {
      addAtBeginning(title, director, year, rating);
      return;
    }
    Movie temp = head;
    for (int i = 1; temp != null && i < position - 1; i++) {
      temp = temp.next;
    }
    if (temp == null || temp == tail) {
      addAtEnd(title, director, year, rating);
      return;
    }
    newMovie.next = temp.next;
    newMovie.prev = temp;
    if (temp.next != null) temp.next.prev = newMovie;
    temp.next = newMovie;
  }

  public void removeByTitle(String title) {
    Movie temp = head;
    while (temp != null) {
      if (temp.title.equalsIgnoreCase(title)) {
        if (temp == head) {
          head = head.next;
          if (head != null) head.prev = null;
        } else if (temp == tail) {
          tail = tail.prev;
          if (tail != null) tail.next = null;
        } else {
          temp.prev.next = temp.next;
          temp.next.prev = temp.prev;
        }
        System.out.println("Movie removed successfully.");
        return;
      }
      temp = temp.next;
    }
    System.out.println("Movie not found.");
  }

  public void searchByDirectorOrRating(String director, double rating) {
    Movie temp = head;
    boolean found = false;
    while (temp != null) {
      if (temp.director.equalsIgnoreCase(director) || temp.rating == rating) {
        System.out.println(
            temp.title
                + " directed by "
                + temp.director
                + ", Year: "
                + temp.year
                + ", Rating: "
                + temp.rating);
        found = true;
      }
      temp = temp.next;
    }
    if (!found) System.out.println("No matching movies found.");
  }

  public void displayForward() {
    Movie temp = head;
    if (temp == null) {
      System.out.println("No movies available.");
      return;
    }
    while (temp != null) {
      System.out.println(
          temp.title + " | " + temp.director + " | " + temp.year + " | Rating: " + temp.rating);
      temp = temp.next;
    }
  }

  public void displayReverse() {
    Movie temp = tail;
    if (temp == null) {
      System.out.println("No movies available.");
      return;
    }
    while (temp != null) {
      System.out.println(
          temp.title + " | " + temp.director + " | " + temp.year + " | Rating: " + temp.rating);
      temp = temp.prev;
    }
  }

  public void updateRating(String title, double newRating) {
    Movie temp = head;
    while (temp != null) {
      if (temp.title.equalsIgnoreCase(title)) {
        temp.rating = newRating;
        System.out.println("Rating updated successfully.");
        return;
      }
      temp = temp.next;
    }
    System.out.println("Movie not found.");
  }
}

public class MovieManagementSystem {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    MovieList movieList = new MovieList();

    while (true) {
      System.out.println("\nMovie Management System");
      System.out.println("1. Add Movie at Beginning");
      System.out.println("2. Add Movie at End");
      System.out.println("3. Add Movie at Specific Position");
      System.out.println("4. Remove Movie by Title");
      System.out.println("5. Search Movie by Director or Rating");
      System.out.println("6. Display All Movies (Forward)");
      System.out.println("7. Display All Movies (Reverse)");
      System.out.println("8. Update Movie Rating");
      System.out.println("9. Exit");
      System.out.print("Enter your choice: ");
      int choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1:
        case 2:
        case 3:
          System.out.print("Enter Title: ");
          String title = scanner.nextLine();
          System.out.print("Enter Director: ");
          String director = scanner.nextLine();
          System.out.print("Enter Year: ");
          int year = scanner.nextInt();
          System.out.print("Enter Rating: ");
          double rating = scanner.nextDouble();
          if (choice == 1) movieList.addAtBeginning(title, director, year, rating);
          else if (choice == 2) movieList.addAtEnd(title, director, year, rating);
          else {
            System.out.print("Enter Position: ");
            int position = scanner.nextInt();
            movieList.addAtPosition(title, director, year, rating, position);
          }
          break;
        case 4:
          System.out.print("Enter Title to Remove: ");
          movieList.removeByTitle(scanner.nextLine());
          break;
        case 5:
          System.out.print("Enter Director or Rating: ");
          movieList.searchByDirectorOrRating(scanner.nextLine(), scanner.nextDouble());
          break;
        case 6:
          movieList.displayForward();
          break;
        case 7:
          movieList.displayReverse();
          break;
        case 8:
          System.out.print("Enter Title to Update Rating: ");
          movieList.updateRating(scanner.nextLine(), scanner.nextDouble());
          break;
        case 9:
          System.exit(0);
        default:
          System.out.println("Invalid choice.");
      }
    }
  }
}
