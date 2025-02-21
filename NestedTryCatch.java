import java.util.*;

public class NestedTryCatch {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    try {
      System.out.print("Enter the size of the array: ");
      int size = sc.nextInt();
      int[] arr = new int[size];

      System.out.println("Enter " + size + " elements:");
      for (int i = 0; i < size; i++) {
        arr[i] = sc.nextInt();
      }

      System.out.print("Enter the index to access: ");
      int index = sc.nextInt();

      try {
        int value = arr[index];
        System.out.print("Enter the divisor: ");
        int divisor = sc.nextInt();
        try {
          int result = value / divisor;
          System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
          System.out.println("Cannot divide by zero!");
        }
      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Invalid array index!");
      }
    } catch (InputMismatchException e) {
      System.out.println("Invalid input! Please enter integers only.");
    } finally {
      sc.close();
    }
  }
}
