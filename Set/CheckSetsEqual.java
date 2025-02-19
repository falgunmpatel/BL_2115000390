import java.util.*;

public class CheckSetsEqual {
  public static boolean checkSetsEqual(Set<Integer> set1, Set<Integer> set2) {
    return set1.equals(set2);
  }

  public static void main(String[] args) {
    Set<Integer> set1 = new HashSet<>(Set.of(1, 2, 3));
    Set<Integer> set2 = new HashSet<>(Set.of(3, 2, 1));
    boolean areEqual = checkSetsEqual(set1, set2);
    System.out.println("Are sets equal: " + areEqual);
  }
}
