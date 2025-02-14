import java.util.*;

public class SortEmployeeIds {
  public static void insertionSort(int[] arr) {
    int n = arr.length - 1;
    for (int i = 1; i <= n; i++) {
      int key = arr[i];
      int j = i - 1;
      while (j >= 0 && arr[j] > key) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = key;
    }
  }

  public static void main(String[] args) {
    int[] employeeIds = {102, 302, 201, 203, 301, 205, 109};
    insertionSort(employeeIds);
    System.out.println(Arrays.toString(employeeIds));
  }
}
