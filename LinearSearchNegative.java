public class LinearSearchNegative {
  public static int findFirstNegative(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < 0) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] numbers = {3, 5, 7, -2, 8, -1, 4};
    int index = findFirstNegative(numbers);

    if (index != -1) {
      System.out.println("First negative number found at index: " + index);
    } else {
      System.out.println("No negative numbers found.");
    }
  }
}
