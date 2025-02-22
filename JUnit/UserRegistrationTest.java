import static org.junit.jupiter.api.Assertions.*;

import java.util.regex.*;
import org.junit.jupiter.api.*;

class UserRegistration {
  public void registerUser(String username, String email, String password) {
    if (username == null || username.isEmpty()) {
      throw new IllegalArgumentException("Username cannot be empty");
    }
    if (email == null || !isValidEmail(email)) {
      throw new IllegalArgumentException("Invalid email format");
    }
    if (password == null || password.length() < 6) {
      throw new IllegalArgumentException("Password must be at least 6 characters long");
    }
  }

  private boolean isValidEmail(String email) {
    String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    Pattern pattern = Pattern.compile(emailRegex);
    return pattern.matcher(email).matches();
  }
}

public class UserRegistrationTest {
  UserRegistration userRegistration;

  @BeforeEach
  public void setUp() {
    userRegistration = new UserRegistration();
  }

  @Test
  public void testRegisterUserValid() {
    assertDoesNotThrow(
        () -> userRegistration.registerUser("JohnDoe", "john.doe@example.com", "password123"));
  }

  @Test
  public void testRegisterUserInvalidUsername() {
    assertThrows(
        IllegalArgumentException.class,
        () -> userRegistration.registerUser("", "john.doe@example.com", "password123"));
  }

  @Test
  public void testRegisterUserInvalidEmail() {
    assertThrows(
        IllegalArgumentException.class,
        () -> userRegistration.registerUser("JohnDoe", "invalid-email", "password123"));
  }

  @Test
  public void testRegisterUserInvalidPassword() {
    assertThrows(
        IllegalArgumentException.class,
        () -> userRegistration.registerUser("JohnDoe", "john.doe@example.com", "123"));
  }
}
