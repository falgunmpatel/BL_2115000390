import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ExceptionHandlingTest {
  public int divide(int a, int b) {
    if (b == 0) {
      throw new ArithmeticException("Division by zero");
    }
    return a / b;
  }

  @Test
  public void testDivideByZero() {
    assertThrows(ArithmeticException.class, () -> divide(1, 0));
  }
}
