import java.util.*;

public class GenerateBinaryNumbers {
  public static void generateBinaryNumbers(int N) {
    Queue<String> queue = new LinkedList<>();
    queue.add("1");
    for (int i = 0; i < N; i++) {
      String current = queue.remove();
      System.out.println(current);
      queue.add(current + "0");
      queue.add(current + "1");
    }
  }

  public static void main(String[] args) {
    int N = 5;
    generateBinaryNumbers(N);
  }
}
