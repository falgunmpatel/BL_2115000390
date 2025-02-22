import java.util.regex.*;

public class SpaceReplacer {
  public String replaceSpaces(String input) {
    return input.replaceAll("\\s+", " ");
  }

  public static void main(String[] args) {
    SpaceReplacer replacer = new SpaceReplacer();
    System.out.println(replacer.replaceSpaces("This is  an  example  with   multiple   spaces."));
  }
}
