import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateComparison {
    public static void compareDates(LocalDate date1, LocalDate date2) {
        if (date1.isBefore(date2)) {
            System.out.println("First date is before the second date.");
        } else if (date1.isAfter(date2)) {
            System.out.println("First date is after the second date.");
        } else {
            System.out.println("Both dates are the same.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            System.out.println("Enter the first date (dd/MM/yyyy):");
            LocalDate date1 = LocalDate.parse(scanner.next(), formatter);

            System.out.println("Enter the second date (dd/MM/yyyy):");
            LocalDate date2 = LocalDate.parse(scanner.next(), formatter);

            compareDates(date1, date2);
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter valid dates in dd/MM/yyyy format.");
        } finally {
            scanner.close();
        }
    }
}

