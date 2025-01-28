import java.util.Scanner;

class LeapYearChecker {

   public static boolean isLeapYear(int year) {
      return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter a year: ");
      int year = scanner.nextInt();

      if (year >= 1582) {
         if (isLeapYear(year)) {
            System.out.println(year + " is a Leap Year.");
         } else {
            System.out.println(year + " is not a Leap Year.");
         }
      } else {
         System.out.println("Year must be greater than or equal to 1582.");
      }
   }
}
