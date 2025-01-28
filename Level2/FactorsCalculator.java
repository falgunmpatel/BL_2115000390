import java.util.*;

class FactorsCalculator {

   public static int[] findFactors(int number) {
      int count = 0;
      for (int i = 1; i <= number; i++) {
         if (number % i == 0) {
            count++;
         }
      }

      int[] factors = new int[count];
      int index = 0;
      for (int i = 1; i <= number; i++) {
         if (number % i == 0) {
            factors[index++] = i;
         }
      }
      return factors;
   }

   public static int sumFactors(int[] factors) {
      int sum = 0;
      for (int factor : factors) {
         sum += factor;
      }
      return sum;
   }

   public static double sumOfSquares(int[] factors) {
      double sum = 0;
      for (int factor : factors) {
         sum += Math.pow(factor, 2);
      }
      return sum;
   }

   public static int productOfFactors(int[] factors) {
      int product = 1;
      for (int factor : factors) {
         product *= factor;
      }
      return product;
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter a number: ");
      int number = scanner.nextInt();

      int[] factors = findFactors(number);
      System.out.println("Factors: " + Arrays.toString(factors));
      System.out.println("Sum of Factors: " + sumFactors(factors));
      System.out.println("Product of Factors: " + productOfFactors(factors));
      System.out.println("Sum of Squares of Factors: " + sumOfSquares(factors));
  }
}
