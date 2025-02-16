import java.util.*;

public class RemoveDuplicates {
  public static String removeDuplicates(String input) {
    StringBuilder sb = new StringBuilder();
    HashSet<Character> seen = new HashSet<>();

    for (char c : input.toCharArray()) {
      if (!seen.contains(c)) {
        sb.append(c);
        seen.add(c);
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    String input = "banana";
    System.out.println("Without duplicates: " + removeDuplicates(input));
  }
}
