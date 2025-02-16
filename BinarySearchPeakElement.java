public class BinarySearchPeakElement {
  public static int findPeakElement(int[] arr) {
    int left = 0, right = arr.length - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;

      if (arr[mid] > arr[mid + 1]) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

  public static void main(String[] args) {
    int[] nums = {1, 3, 5, 4, 2};
    int peakIndex = findPeakElement(nums);
    System.out.println("Peak element found at index: " + peakIndex);
  }
}
