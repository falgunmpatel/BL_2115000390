import java.util.regex.*;

public class HexColorValidator {
  public boolean validate(String color) {
    String regex = "^#([A-Fa-f0-9]{6})$";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(color);
    return matcher.matches();
  }

  public static void main(String[] args) {
    HexColorValidator validator = new HexColorValidator();
    System.out.println(validator.validate("#FFA500"));
    System.out.println(validator.validate("#ff4500"));
    System.out.println(validator.validate("#123"));
  }
}
