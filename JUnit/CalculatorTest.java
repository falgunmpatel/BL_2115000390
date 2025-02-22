import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

class Calculator {
  public int add(int a, int b) {
    return a + b;
  }

  public int subtract(int a, int b) {
    return a - b;
  }

  public int multiply(int a, int b) {
    return a * b;
  }

  public int divide(int a, int b) {
    if (b == 0) {
      throw new ArithmeticException("Division by zero");
    }
    return a / b;
  }
}

public class CalculatorTest {
  Calculator calculator = new Calculator();

  @Test
  public void testAdd() {
    assertEquals(5, calculator.add(2, 3));
  }

  @Test
  public void testSubtract() {
    assertEquals(1, calculator.subtract(3, 2));
  }

  @Test
  public void testMultiply() {
    assertEquals(6, calculator.multiply(2, 3));
  }

  @Test
  public void testDivide() {
    assertEquals(2, calculator.divide(6, 3));
  }

  @Test
  public void testDivideByZero() {
    assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0));
  }
}
