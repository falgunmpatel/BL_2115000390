import java.util.Scanner;

class NaturalNumberSum {

   public static int recursiveSum(int n) {
      if (n == 0) return 0;
      return n + recursiveSum(n - 1);
   }

   public static int formulaSum(int n) {
      return n * (n + 1) / 2;
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter a natural number: ");
      int n = scanner.nextInt();

      if (n < 1) {
         System.out.println("Input must be a natural number.");
         return;
      }

      int recursiveResult = recursiveSum(n);
      int formulaResult = formulaSum(n);

      System.out.println("Recursive Sum: " + recursiveResult);
      System.out.println("Formula Sum: " + formulaResult);

      if (recursiveResult == formulaResult) {
         System.out.println("Both results are correct!");
      } else {
         System.out.println("There is an error in the calculation.");
      }
   }
}
