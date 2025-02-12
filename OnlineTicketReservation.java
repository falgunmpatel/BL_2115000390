import java.util.Scanner;

class TicketNode {
  int ticketID;
  String customerName;
  String movieName;
  String seatNumber;
  String bookingTime;
  TicketNode next;

  public TicketNode(
      int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
    this.ticketID = ticketID;
    this.customerName = customerName;
    this.movieName = movieName;
    this.seatNumber = seatNumber;
    this.bookingTime = bookingTime;
    this.next = null;
  }
}

class TicketReservationSystem {
  private TicketNode head = null;
  private TicketNode tail = null;
  private int ticketCount = 0;

  public void addTicket(
      int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
    TicketNode newTicket =
        new TicketNode(ticketID, customerName, movieName, seatNumber, bookingTime);
    ticketCount++;

    if (head == null) {
      head = newTicket;
      tail = newTicket;
      newTicket.next = head;
    } else {
      tail.next = newTicket;
      newTicket.next = head;
      tail = newTicket;
    }
    System.out.println("Ticket booked successfully for " + customerName);
  }

  public void removeTicket(int ticketID) {
    if (head == null) {
      System.out.println("No tickets available.");
      return;
    }

    TicketNode current = head;
    TicketNode previous = tail;
    boolean found = false;

    do {
      if (current.ticketID == ticketID) {
        found = true;
        if (current == head && current == tail) {
          head = null;
          tail = null;
        } else if (current == head) {
          head = head.next;
          tail.next = head;
        } else if (current == tail) {
          tail = previous;
          tail.next = head;
        } else {
          previous.next = current.next;
        }

        ticketCount--;
        System.out.println(" Ticket ID " + ticketID + " removed successfully.");
        return;
      }
      previous = current;
      current = current.next;
    } while (current != head);

    if (!found) {
      System.out.println(" Ticket ID " + ticketID + " not found.");
    }
  }

  public void displayTickets() {
    if (head == null) {
      System.out.println(" No tickets booked.");
      return;
    }

    System.out.println("\n List of Booked Tickets:");
    TicketNode current = head;
    do {
      System.out.println(
          "Ticket ID: "
              + current.ticketID
              + ", Customer: "
              + current.customerName
              + ", Movie: "
              + current.movieName
              + ", Seat: "
              + current.seatNumber
              + ", Time: "
              + current.bookingTime);
      current = current.next;
    } while (current != head);
  }

  public void searchTicket(String searchKey) {
    if (head == null) {
      System.out.println("⚠ No tickets available.");
      return;
    }

    TicketNode current = head;
    boolean found = false;

    do {
      if (current.customerName.equalsIgnoreCase(searchKey)
          || current.movieName.equalsIgnoreCase(searchKey)) {
        System.out.println(
            " Ticket Found -> Ticket ID: "
                + current.ticketID
                + ", Customer: "
                + current.customerName
                + ", Movie: "
                + current.movieName
                + ", Seat: "
                + current.seatNumber
                + ", Time: "
                + current.bookingTime);
        found = true;
      }
      current = current.next;
    } while (current != head);

    if (!found) {
      System.out.println(" No ticket found for " + searchKey);
    }
  }

  public void totalTickets() {
    System.out.println("Total Booked Tickets: " + ticketCount);
  }
}

public class OnlineTicketReservation {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    TicketReservationSystem system = new TicketReservationSystem();

    while (true) {
      System.out.println("\n Online Ticket Reservation System");
      System.out.println("1. Book a Ticket");
      System.out.println("2. Cancel a Ticket");
      System.out.println("3. View All Tickets");
      System.out.println("4. Search Ticket by Customer or Movie Name");
      System.out.println("5. View Total Tickets");
      System.out.println("6. Exit");
      System.out.print("Enter your choice: ");

      int choice = scanner.nextInt();
      scanner.nextLine(); // Consume newline

      switch (choice) {
        case 1:
          System.out.print("Enter Ticket ID: ");
          int ticketID = scanner.nextInt();
          scanner.nextLine(); // Consume newline

          System.out.print("Enter Customer Name: ");
          String customerName = scanner.nextLine();

          System.out.print("Enter Movie Name: ");
          String movieName = scanner.nextLine();

          System.out.print("Enter Seat Number: ");
          String seatNumber = scanner.nextLine();

          System.out.print("Enter Booking Time: ");
          String bookingTime = scanner.nextLine();

          system.addTicket(ticketID, customerName, movieName, seatNumber, bookingTime);
          break;

        case 2:
          System.out.print("Enter Ticket ID to cancel: ");
          int cancelID = scanner.nextInt();
          system.removeTicket(cancelID);
          break;

        case 3:
          system.displayTickets();
          break;

        case 4:
          System.out.print("Enter Customer Name or Movie Name: ");
          String searchKey = scanner.nextLine();
          system.searchTicket(searchKey);
          break;

        case 5:
          system.totalTickets();
          break;

        case 6:
          System.out.println("🚪 Exiting... Thank you!");
          scanner.close();
          return;

        default:
          System.out.println("❌ Invalid choice! Try again.");
      }
    }
  }
}
