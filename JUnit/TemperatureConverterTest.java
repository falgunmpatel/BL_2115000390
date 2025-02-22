import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

class TemperatureConverter {
  public double celsiusToFahrenheit(double celsius) {
    return (celsius * 9 / 5) + 32;
  }

  public double fahrenheitToCelsius(double fahrenheit) {
    return (fahrenheit - 32) * 5 / 9;
  }
}

public class TemperatureConverterTest {
  TemperatureConverter converter;

  @BeforeEach
  public void setUp() {
    converter = new TemperatureConverter();
  }

  @Test
  public void testCelsiusToFahrenheit() {
    assertEquals(32.0, converter.celsiusToFahrenheit(0.0), 0.001);
  }

  @Test
  public void testFahrenheitToCelsius() {
    assertEquals(0.0, converter.fahrenheitToCelsius(32.0), 0.001);
  }
}
