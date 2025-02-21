import java.util.*;

public class UncheckedException {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    try {
      System.out.print("Enter the first number: ");
      int num1 = sc.nextInt();

      System.out.print("Enter the second number: ");
      int num2 = sc.nextInt();

      int result = num1 / num2;
      System.out.println("Result: " + result);
    } catch (ArithmeticException e) {
      System.out.println("Error: Division by zero is not allowed.");
    } catch (InputMismatchException e) {
      System.out.println("Error: Please enter valid numeric values.");
    } finally {
      sc.close();
    }
  }
}
