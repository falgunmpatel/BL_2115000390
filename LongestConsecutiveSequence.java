import java.util.HashMap;

public class LongestConsecutiveSequence {
  public static int LongestSequence(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    HashMap<Integer, Boolean> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, true);
    }
    int longestSequence = 0;
    for (int num : nums) {
      if (!map.containsKey(num - 1)) {
        int currentstreak = 1;
        int currentnum = num;
        while (map.containsKey(currentnum + 1)) {
          currentstreak++;
          currentnum++;
        }
        longestSequence = Math.max(longestSequence, currentstreak);
      }
    }
    return longestSequence;
  }

  public static void main(String[] args) {
    int nums[] = {1, 232, 3, 2, 4, 222, 5};
    System.out.println("Longest Sequence is:" + LongestSequence(nums));
  }
}
