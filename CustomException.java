import java.util.*;

class InvalidAgeException extends Exception {
  public InvalidAgeException(String message) {
    super(message);
  }
}

public class CustomException {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    try {
      System.out.println("Enter the Age : ");
      int age = sc.nextInt();
      validateAge(age);
    } catch (InvalidAgeException e) {
      System.out.println(e.getMessage());
    } finally {
      sc.close();
    }
  }

  public static void validateAge(int age) throws InvalidAgeException {
    if (age >= 18) {
      System.out.println("Access Granted!");
    } else {
      throw new InvalidAgeException("Age must be equal to or greater than 18");
    }
  }
}
