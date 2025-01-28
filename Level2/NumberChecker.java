import java.util.Scanner;

class NumberChecker {

   public static String isPositive(int number) {
      return (number >= 0) ? "Positive" : "Negative";
   }

   public static String isEvenOrOdd(int number) {
      return (number % 2 == 0) ? "Even" : "Odd";
   }

   public static int compareNumbers(int num1, int num2) {
      if (num1 > num2) {
         return 1;
      } else if (num1 == num2) {
         return 0;
      } else {
         return -1;
      }
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int[] numbers = new int[5];

      for (int i = 0; i < 5; i++) {
         System.out.print("Enter number " + (i + 1) + ": ");
         numbers[i] = scanner.nextInt();
      }

      for (int num : numbers) {
         System.out.println(num + " is " + isPositive(num));
         if (num >= 0) {
            System.out.println(num + " is " + isEvenOrOdd(num));
         }
      }

      int result = compareNumbers(numbers[0], numbers[4]);
      if (result == 1) {
         System.out.println("First number is greater than last number.");
      } else if (result == 0) {
         System.out.println("First and last numbers are equal.");
      } else {
         System.out.println("First number is less than last number.");
      }
   }
}
