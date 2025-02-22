import java.util.regex.*;

public class LicensePlateValidator {
  public boolean validate(String plate) {
    String regex = "^[A-Z]{2}\\d{4}$";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(plate);
    return matcher.matches();
  }

  public static void main(String[] args) {
    LicensePlateValidator validator = new LicensePlateValidator();
    System.out.println(validator.validate("AB1234"));
    System.out.println(validator.validate("A12345"));
  }
}
