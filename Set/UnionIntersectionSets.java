import java.util.*;

public class UnionIntersectionSets {
  public static Set<Integer> findUnion(Set<Integer> set1, Set<Integer> set2) {
    Set<Integer> unionSet = new HashSet<>(set1);
    unionSet.addAll(set2);
    return unionSet;
  }

  public static Set<Integer> findIntersection(Set<Integer> set1, Set<Integer> set2) {
    Set<Integer> intersectionSet = new HashSet<>(set1);
    intersectionSet.retainAll(set2);
    return intersectionSet;
  }

  public static void main(String[] args) {
    Set<Integer> set1 = new HashSet<>(Set.of(1, 2, 3));
    Set<Integer> set2 = new HashSet<>(Set.of(3, 4, 5));
    Set<Integer> unionSet = findUnion(set1, set2);
    Set<Integer> intersectionSet = findIntersection(set1, set2);
    System.out.println("Union: " + unionSet);
    System.out.println("Intersection: " + intersectionSet);
  }
}
