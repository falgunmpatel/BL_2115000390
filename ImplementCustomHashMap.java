class CustomHashMap<K, V> {
  private static final int DEFAULT_CAPACITY = 16;
  private static final double LOAD_FACTOR = 0.75;

  private static class Node<K, V> {
    K key;
    V value;
    Node<K, V> next;

    Node(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }

  private Node<K, V>[] buckets;
  private int size;

  @SuppressWarnings("unchecked")
  public CustomHashMap() {
    buckets = new Node[DEFAULT_CAPACITY];
    size = 0;
  }

  private int hash(K key) {
    return (key == null) ? 0 : Math.abs(key.hashCode()) % buckets.length;
  }

  public void put(K key, V value) {
    int index = hash(key);
    Node<K, V> head = buckets[index];

    while (head != null) {
      if (head.key.equals(key)) {
        head.value = value;
        return;
      }
      head = head.next;
    }

    Node<K, V> newNode = new Node<>(key, value);
    newNode.next = buckets[index];
    buckets[index] = newNode;
    size++;

    if ((double) size / buckets.length > LOAD_FACTOR) {
      resize();
    }
  }

  public V get(K key) {
    int index = hash(key);
    Node<K, V> head = buckets[index];

    while (head != null) {
      if (head.key.equals(key)) {
        return head.value;
      }
      head = head.next;
    }
    return null;
  }

  public boolean remove(K key) {
    int index = hash(key);
    Node<K, V> head = buckets[index];
    Node<K, V> prev = null;

    while (head != null) {
      if (head.key.equals(key)) {
        if (prev != null) {
          prev.next = head.next;
        } else {
          buckets[index] = head.next;
        }
        size--;
        return true;
      }
      prev = head;
      head = head.next;
    }
    return false;
  }

  @SuppressWarnings("unchecked")
  private void resize() {
    Node<K, V>[] oldBuckets = buckets;
    buckets = new Node[oldBuckets.length * 2];
    size = 0;

    for (Node<K, V> head : oldBuckets) {
      while (head != null) {
        put(head.key, head.value);
        head = head.next;
      }
    }
  }

  public int size() {
    return size;
  }

  public boolean containsKey(K key) {
    return get(key) != null;
  }
}

public class ImplementCustomHashMap {
  public static void main(String[] args) {
    CustomHashMap<Integer, String> map = new CustomHashMap<>();

    map.put(1, "Apple");
    map.put(2, "Banana");
    map.put(3, "Cherry");
    map.put(4, "Date");

    System.out.println("Value for key 1: " + map.get(1));
    System.out.println("Value for key 3: " + map.get(3));

    // Update an existing key
    map.put(2, "Blueberry");
    System.out.println("Updated value for key 2: " + map.get(2));

    // Remove a key
    System.out.println("Removing key 3: " + map.remove(3));
    System.out.println("Value for key 3 after removal: " + map.get(3));

    // Check size of the map
    System.out.println("Current size: " + map.size());

    // Check if key exists
    System.out.println("Contains key 4? " + map.containsKey(4));
    System.out.println("Contains key 5? " + map.containsKey(5));

    // Adding more elements to trigger resizing
    for (int i = 5; i <= 20; i++) {
      map.put(i, "Value" + i);
    }

    System.out.println("Size after multiple insertions: " + map.size());
    System.out.println("Value for key 15: " + map.get(15));
  }
}
