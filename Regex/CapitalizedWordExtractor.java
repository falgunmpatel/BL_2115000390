import java.util.*;
import java.util.regex.*;

public class CapitalizedWordExtractor {
  public List<String> extract(String text) {
    List<String> words = new ArrayList<>();
    String regex = "\\b[A-Z][a-z]*\\b";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(text);

    while (matcher.find()) {
      words.add(matcher.group());
    }

    return words;
  }

  public static void main(String[] args) {
    CapitalizedWordExtractor extractor = new CapitalizedWordExtractor();

    List<String> words =
        extractor.extract("The Eiffel Tower is in Paris and the Statue of Liberty is in New York.");
    for (String word : words) {
      System.out.println(word);
    }
  }
}
