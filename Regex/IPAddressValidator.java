import java.util.regex.*;

public class IPAddressValidator {
  public boolean validate(String ip) {
    String regex =
        "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(ip);
    return matcher.matches();
  }

  public static void main(String[] args) {
    IPAddressValidator validator = new IPAddressValidator();
    System.out.println(validator.validate("192.168.0.1"));
    System.out.println(validator.validate("256.256.256.256"));
  }
}
