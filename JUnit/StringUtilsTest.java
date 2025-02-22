import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringUtils {
  public String reverse(String str) {
    return new StringBuilder(str).reverse().toString();
  }

  public boolean isPalindrome(String str) {
    String reversed = reverse(str);
    return str.equals(reversed);
  }

  public String toUpperCase(String str) {
    return str.toUpperCase();
  }
}

public class StringUtilsTest {
  StringUtils stringUtils = new StringUtils();

  @Test
  public void testReverse() {
    assertEquals("cba", stringUtils.reverse("abc"));
  }

  @Test
  public void testIsPalindrome() {
    assertTrue(stringUtils.isPalindrome("madam"));
    assertFalse(stringUtils.isPalindrome("hello"));
  }

  @Test
  public void testToUpperCase() {
    assertEquals("HELLO", stringUtils.toUpperCase("hello"));
  }
}
