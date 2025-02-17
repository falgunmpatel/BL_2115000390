import java.util.Arrays;
import java.util.Random;

public class SearchComparision {
  public static void main(String[] args) {
    int[] sizes = {1000, 10000, 1000000};
    Random rand = new Random();

    for (int size : sizes) {
      int[] data = new int[size];

      for (int i = 0; i < size; i++) {
        data[i] = rand.nextInt(size * 10);
      }
      int target = data[rand.nextInt(size)];

      // Linear Search
      long startTime = System.nanoTime();
      LinearSearch(data, target);
      long linearTime = System.nanoTime() - startTime;

      Arrays.sort(data);

      // Binary Search
      startTime = System.nanoTime();
      BinarySearch(data, target);
      long binaryTime = System.nanoTime() - startTime;

      System.out.println("Dataset Size: " + size);
      System.out.println("Linear Search Time: " + linearTime / 1_000_000.0 + " ms");
      System.out.println("Binary Search Time: " + binaryTime / 1_000_000.0 + " ms");
    }
  }

  public static int LinearSearch(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == target) {
        return i;
      }
    }
    return -1;
  }

  public static int BinarySearch(int[] arr, int target) {
    int left = 0, right = arr.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] == target) return mid;
      if (arr[mid] < target) left = mid + 1;
      else right = mid - 1;
    }
    return -1;
  }
}
