import java.util.regex.*;

public class SSNValidator {
  public boolean validate(String ssn) {
    String regex = "^\\d{3}-\\d{2}-\\d{4}$";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(ssn);
    return matcher.matches();
  }

  public static void main(String[] args) {
    SSNValidator validator = new SSNValidator();
    System.out.println(validator.validate("123-45-6789"));
    System.out.println(validator.validate("123456789"));
  }
}
