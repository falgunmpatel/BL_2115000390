import java.util.*;

public class CheckSubset {
  public static boolean checkSubset(Set<Integer> subset, Set<Integer> superset) {
    return superset.containsAll(subset);
  }

  public static void main(String[] args) {
    Set<Integer> set1 = new HashSet<>(Set.of(2, 3));
    Set<Integer> set2 = new HashSet<>(Set.of(1, 2, 3, 4));
    boolean isSubset = checkSubset(set1, set2);
    System.out.println("Is set1 a subset of set2: " + isSubset);
  }
}
