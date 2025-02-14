import java.util.*;

class PairSum {
  public static boolean hasPairWithSum(int[] nums, int target) {
    Map<Integer, Integer> numMap = new HashMap<>();

    for (int num : nums) {
      int complement = target - num;
      if (numMap.containsKey(complement)) {
        System.out.println("Pair found: (" + num + ", " + complement + ")");
        return true;
      }
      numMap.put(num, 1);
    }
    System.out.println("No pair found.");
    return false;
  }

  public static void main(String[] args) {
    int[] nums = {2, 7, 11, 15, 5};
    int target = 9;

    hasPairWithSum(nums, target);
  }
}
