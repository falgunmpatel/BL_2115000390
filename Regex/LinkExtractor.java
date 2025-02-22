import java.util.*;
import java.util.regex.*;

public class LinkExtractor {
  public List<String> extract(String text) {
    List<String> links = new ArrayList<>();
    String regex = "https?://[^\\s]+";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(text);
    while (matcher.find()) {
      links.add(matcher.group());
    }
    return links;
  }

  public static void main(String[] args) {
    LinkExtractor extractor = new LinkExtractor();
    List<String> links =
        extractor.extract("Visit https://www.google.com and http://example.org for more info.");
    for (String link : links) {
      System.out.println(link);
    }
  }
}
