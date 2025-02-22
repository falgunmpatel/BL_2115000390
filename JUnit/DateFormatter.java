import static org.junit.jupiter.api.Assertions.*;

import java.time.*;
import java.time.format.*;
import java.time.format.DateTimeParseException;
import org.junit.jupiter.api.*;

class DateFormatter {
  public String formatDate(String inputDate) {
    try {
      LocalDate date = LocalDate.parse(inputDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
      return date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    } catch (DateTimeParseException e) {
      throw new IllegalArgumentException("Invalid date format");
    }
  }
}

public class DateFormatterTest {
  DateFormatter formatter;

  @BeforeEach
  public void setUp() {
    formatter = new DateFormatter();
  }

  @Test
  public void testFormatDateValid() {
    assertEquals("22-02-2025", formatter.formatDate("2025-02-22"));
  }

  @Test
  public void testFormatDateInvalid() {
    assertThrows(IllegalArgumentException.class, () -> formatter.formatDate("22-02-2025"));
  }
}
