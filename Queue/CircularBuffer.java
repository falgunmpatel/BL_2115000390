public class CircularBuffer {
  private int[] buffer;
  private int head;
  private int tail;
  private int size;
  private int capacity;

  public CircularBuffer(int capacity) {
    this.capacity = capacity;
    this.buffer = new int[capacity];
    this.head = 0;
    this.tail = 0;
    this.size = 0;
  }

  public void insert(int value) {
    if (size == capacity) {
      head = (head + 1) % capacity;
    } else {
      size++;
    }
    buffer[tail] = value;
    tail = (tail + 1) % capacity;
  }

  public void printBuffer() {
    System.out.println("Buffer : ");
    for (int i = 0; i < size; i++) {
      System.out.print(buffer[(head + i) % capacity] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    CircularBuffer buffer = new CircularBuffer(3);
    buffer.insert(1);
    buffer.insert(2);
    buffer.insert(3);
    buffer.printBuffer();
    buffer.insert(4);
    buffer.printBuffer();
  }
}
