import java.util.*;

public class NthElementFromEnd {
  public static void main(String[] args) {
    LinkedList<String> list = new LinkedList<>();
    list.add("A");
    list.add("B");
    list.add("C");
    list.add("D");
    list.add("E");
    int N = 2;
    String result = findNthFromEnd(list, N);
    System.out.println(result);
  }

  public static String findNthFromEnd(LinkedList<String> list, int N) {
    ListIterator<String> lead = list.listIterator();
    ListIterator<String> follow = list.listIterator();

    for (int i = 0; i < N; i++) {
      if (lead.hasNext()) {
        lead.next();
      } else {
        return null;
      }
    }

    while (lead.hasNext()) {
      lead.next();
      follow.next();
    }

    return follow.next();
  }
}
