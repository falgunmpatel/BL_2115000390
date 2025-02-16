public class LinearSearchMissingPositive {
  public static int findFirstMissingPositive(int[] arr) {
    int n = arr.length;
    boolean[] present = new boolean[n + 1];

    for (int num : arr) {
      if (num > 0 && num <= n) {
        present[num] = true;
      }
    }

    for (int i = 1; i <= n; i++) {
      if (!present[i]) {
        return i;
      }
    }
    return n + 1;
  }

  public static void main(String[] args) {
    int[] nums = {3, 4, -1, 1};
    System.out.println("First missing positive: " + findFirstMissingPositive(nums));
  }
}
