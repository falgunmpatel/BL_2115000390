import java.util.*;

public class BinarySearchTargetIndex {
  public static int binarySearch(int[] arr, int target) {
    int left = 0, right = arr.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (arr[mid] == target) {
        return mid;
      } else if (arr[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] nums = {3, 1, 4, 2, 5};
    int target = 4;

    Arrays.sort(nums);
    int index = binarySearch(nums, target);

    System.out.println("Index of " + target + ": " + index);
  }
}
