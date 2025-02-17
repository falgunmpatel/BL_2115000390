import java.util.*;

public class DatatStructureSearchComparison {
  public static void main(String[] args) {
    int N = 1000000;
    int searchValue = N / 2;
    int[] array = new int[N];
    HashSet<Integer> hashSet = new HashSet<>();
    TreeSet<Integer> treeSet = new TreeSet<>();

    for (int i = 0; i < N; i++) {
      array[i] = i;
      hashSet.add(i);
      treeSet.add(i);
    }

    // Search Time in Array
    long startTime = System.nanoTime();
    boolean foundInArray = linearSearch(array, searchValue);
    long arraySearchTime = System.nanoTime() - startTime;

    // Search time in HashSet
    startTime = System.nanoTime();
    boolean foundInHashSet = hashSet.contains(searchValue);
    long hashSetSearchTime = System.nanoTime() - startTime;

    // Search Time in TreeSet
    startTime = System.nanoTime();
    boolean foundInTreeSet = treeSet.contains(searchValue);
    long treeSetSearchTime = System.nanoTime() - startTime;

    System.out.println(
        "Array Search: " + (arraySearchTime / 1000000) + " ms (Found: " + foundInArray + ")");
    System.out.println(
        "HashSet Search: " + (hashSetSearchTime / 1000000) + " ms (Found: " + foundInHashSet + ")");
    System.out.println(
        "TreeSet Search: " + (treeSetSearchTime / 1000000) + " ms (Found: " + foundInTreeSet + ")");
  }

  public static boolean linearSearch(int[] arr, int key) {
    for (int num : arr) {
      if (num == key) {
        return true;
      }
    }
    return false;
  }
}
