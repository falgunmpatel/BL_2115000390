import java.util.*;

public class DivisionWithFinally {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    try {
      System.out.print("Enter the numerator: ");
      int numerator = sc.nextInt();
      System.out.print("Enter the denominator: ");
      int denominator = sc.nextInt();
      int result = numerator / denominator;
      System.out.println("Result: " + result);
    } catch (ArithmeticException e) {
      System.out.println("Cannot divide by zero.");
    } catch (InputMismatchException e) {
      System.out.println("Invalid input! Please enter integers only.");
    } finally {
      System.out.println("Operation completed.");
      sc.close();
    }
  }
}
