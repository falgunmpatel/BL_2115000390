import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterizedTestExample {
  public boolean isEven(int number) {
    return number % 2 == 0;
  }

  @ParameterizedTest
  @ValueSource(ints = {2, 4, 6, 7, 9})
  public void testIsEven(int number) {
    if (number % 2 == 0) {
      assertTrue(isEven(number));
    } else {
      assertFalse(isEven(number));
    }
  }
}
