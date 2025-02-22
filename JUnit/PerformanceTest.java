import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class PerformanceTest {
  public void longRunningTask() throws InterruptedException {
    Thread.sleep(3000);
  }

  @Test
  @Timeout(2)
  public void testLongRunningTask() {
    assertThrows(InterruptedException.class, () -> longRunningTask());
  }
}
