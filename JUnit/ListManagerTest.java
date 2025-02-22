import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import org.junit.jupiter.api.*;

class ListManager {
  public void addElement(List<Integer> list, int element) {
    list.add(element);
  }

  public void removeElement(List<Integer> list, int element) {
    list.remove(Integer.valueOf(element));
  }

  public int getSize(List<Integer> list) {
    return list.size();
  }
}

public class ListManagerTest {
  ListManager listManager;
  List<Integer> list;

  @BeforeEach
  public void setUp() {
    listManager = new ListManager();
    list = new ArrayList<>();
  }

  @Test
  public void testAddElement() {
    listManager.addElement(list, 5);
    assertTrue(list.contains(5));
  }

  @Test
  public void testRemoveElement() {
    listManager.addElement(list, 5);
    listManager.removeElement(list, 5);
    assertFalse(list.contains(5));
  }

  @Test
  public void testGetSize() {
    listManager.addElement(list, 5);
    assertEquals(1, listManager.getSize(list));
  }
}
