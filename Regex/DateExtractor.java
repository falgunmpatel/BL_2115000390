import java.util.*;
import java.util.regex.*;

public class DateExtractor {
  public List<String> extract(String text) {
    List<String> dates = new ArrayList<>();
    String regex = "\\b\\d{2}/\\d{2}/\\d{4}\\b";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(text);

    while (matcher.find()) {
      dates.add(matcher.group());
    }
    return dates;
  }

  public static void main(String[] args) {
    DateExtractor extractor = new DateExtractor();
    List<String> dates =
        extractor.extract("The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.");
    for (String date : dates) {
      System.out.println(date);
    }
  }
}
