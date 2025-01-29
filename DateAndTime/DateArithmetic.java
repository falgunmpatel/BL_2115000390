import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateArithmetic {
    public static void performDateArithmetic(LocalDate date) {
        LocalDate modifiedDate = date.plusDays(7).plusMonths(1).plusYears(2).minusWeeks(3);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        System.out.println("Original Date: " + date.format(formatter));
        System.out.println("Modified Date after arithmetic: " + modifiedDate.format(formatter));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            System.out.println("Enter a date (dd/MM/yyyy):");
            String inputDate = scanner.next();
            LocalDate date = LocalDate.parse(inputDate, formatter);

            performDateArithmetic(date);
        } catch (Exception e) {
            System.out.println("Invalid date format! Please enter a valid date in dd/MM/yyyy format.");
        } finally {
            scanner.close();
        }
    }
}

