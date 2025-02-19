import java.util.*;

public class RotateList {
  public static void rotateList(List<Integer> list, int k) {
    int size = list.size();
    List<Integer> tempList = new ArrayList<>(list.subList(k % size, size));
    tempList.addAll(list.subList(0, k % size));
    list.clear();
    list.addAll(tempList);
  }

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>(List.of(10, 20, 30, 40, 50));
    int rotateBy = 2;
    rotateList(list, rotateBy);
    System.out.println(list);
  }
}
