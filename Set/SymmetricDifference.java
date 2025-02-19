import java.util.*;

public class SymmetricDifference {
  public static Set<Integer> findSymmetricDifference(Set<Integer> set1, Set<Integer> set2) {
    Set<Integer> symmetricDiff = new HashSet<>(set1);
    symmetricDiff.addAll(set2);
    Set<Integer> tempSet = new HashSet<>(set1);
    tempSet.retainAll(set2);
    symmetricDiff.removeAll(tempSet);
    return symmetricDiff;
  }

  public static void main(String[] args) {
    Set<Integer> set1 = new HashSet<>(Set.of(1, 2, 3));
    Set<Integer> set2 = new HashSet<>(Set.of(3, 4, 5));
    Set<Integer> symmetricDiff = findSymmetricDifference(set1, set2);
    System.out.println("Symmetric Difference: " + symmetricDiff);
  }
}
