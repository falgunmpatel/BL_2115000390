import java.util.*;
import java.util.regex.*;

public class ProgrammingLanguageExtractor {
  public List<String> extract(String text) {
    List<String> languages = new ArrayList<>();
    String regex = "\\b(Java|Python|JavaScript|Go|C\\+\\+|Ruby|C#|Swift|Kotlin)\\b";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(text);

    while (matcher.find()) {
      languages.add(matcher.group());
    }

    return languages;
  }

  public static void main(String[] args) {
    ProgrammingLanguageExtractor extractor = new ProgrammingLanguageExtractor();
    List<String> languages =
        extractor.extract("I love GO, JavaScript, but Java is not that interesting!!.");

    for (String language : languages) {
      System.out.println(language);
    }
  }
}
