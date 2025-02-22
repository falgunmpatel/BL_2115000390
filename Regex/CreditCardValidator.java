import java.util.regex.*;

public class CreditCardValidator {
  public boolean validateVisa(String cardNumber) {
    String regex = "^4[0-9]{15}$";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(cardNumber);
    return matcher.matches();
  }

  public boolean validateMasterCard(String cardNumber) {
    String regex = "^5[0-9]{15}$";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(cardNumber);
    return matcher.matches();
  }

  public static void main(String[] args) {
    CreditCardValidator validator = new CreditCardValidator();
    System.out.println(validator.validateVisa("438487593789002"));
    System.out.println(validator.validateMasterCard("5111111111111111"));
  }
}
