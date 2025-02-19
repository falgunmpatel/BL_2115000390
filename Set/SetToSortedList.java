import java.util.*;

public class SetToSortedList {
  public static List<Integer> convertToSortedList(Set<Integer> set) {
    List<Integer> sortedList = new ArrayList<>(set);
    Collections.sort(sortedList);
    return sortedList;
  }

  public static void main(String[] args) {
    Set<Integer> hashSet = new HashSet<>(Set.of(5, 3, 9, 1));
    List<Integer> sortedList = convertToSortedList(hashSet);
    System.out.println("Sorted List: " + sortedList);
  }
}
