import java.util.*;
import java.util.regex.*;

public class EmailExtractor {
  public List<String> extract(String text) {
    List<String> emails = new ArrayList<>();
    String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(text);

    while (matcher.find()) {
      emails.add(matcher.group());
    }

    return emails;
  }

  public static void main(String[] args) {
    EmailExtractor extractor = new EmailExtractor();
    List<String> emails =
        extractor.extract("Contact us at support@example.com and info@company.org");

    for (String email : emails) {
      System.out.println(email);
    }
  }
}
