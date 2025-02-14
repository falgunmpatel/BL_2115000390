import java.util.*;

public class SortStudentMarks {
  static void bubbleSort(int[] arr) {
    int n = arr.length - 1;
    for (int i = 0; i < n; i++) {
      boolean swap = false;
      for (int j = 0; j < n - i; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
          swap = true;
        }
      }
      if (swap == false) break;
    }
  }

  public static void main(String[] args) {
    int[] marks = {85, 46, 55, 78, 99, 27, 35};
    bubbleSort(marks);
    System.out.println(Arrays.toString(marks));
  }
}
