import java.util.regex.*;

public class UsernameValidator {
  public boolean validate(String username) {
    String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(username);
    return matcher.matches();
  }

  public static void main(String[] args) {
    UsernameValidator validator = new UsernameValidator();
    System.out.println(validator.validate("user111"));
    System.out.println(validator.validate("user222"));
    System.out.println(validator.validate("us"));
  }
}
