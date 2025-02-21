import java.util.*;

public class ArrayOperations {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    try {
      System.out.print("Enter the number of elements in the array: ");
      int n = sc.nextInt();
      Integer[] arr = new Integer[n];
      System.out.println("Enter the elements:");
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.print("Enter the index to retrieve value: ");
      int index = sc.nextInt();
      System.out.println("Value at index " + index + ": " + arr[index]);
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Invalid index!");
    } catch (NullPointerException e) {
      System.out.println("Array is not initialized!");
    } finally {
      sc.close();
    }
  }
}
