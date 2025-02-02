import java.util.*;

class HotelBooking {
    String guestName;
    String roomType;
    int nights;

    HotelBooking() {
        this.guestName = "Guest" + (int) ( Math.random() * 1000);
        this.roomType = "Double";
        this.nights = 1;
    }

    HotelBooking(String guestName,String  roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    HotelBooking(HotelBooking booking) {
        this.guestName = booking.guestName;
        this.roomType = booking.roomType;
        this.nights = booking.nights;
    }

    void displayHotelBooking() {
        System.out.println("**********************");
        System.out.println();

        System.out.println("Booking Details: ");
        System.out.println("Guest Name: " + this.guestName);
        System.out.println("Room Type: " + this.roomType);
        System.out.println("Nights: " + this.nights);

        System.out.println();
        System.out.println("**********************");
    }
}

public class HotelBookingExample {
    public static void main (String []args) {
        HotelBooking booking1 = new HotelBooking();
        HotelBooking booking2 = new HotelBooking("Random_Guest_01", "Deluxe", 3);
        HotelBooking booking3 = new HotelBooking(booking2);
        booking1.displayHotelBooking();
        booking2.displayHotelBooking();
        booking3.displayHotelBooking();
    }
}
