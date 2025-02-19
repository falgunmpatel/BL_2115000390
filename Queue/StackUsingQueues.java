import java.util.*;

public class StackUsingQueues {
  private Queue<Integer> queue1 = new LinkedList<>();
  private Queue<Integer> queue2 = new LinkedList<>();

  public void push(int x) {
    queue1.add(x);
  }

  public int pop() {
    while (queue1.size() > 1) {
      queue2.add(queue1.remove());
    }
    int el = queue1.remove();
    Queue<Integer> temp = queue1;
    queue1 = queue2;
    queue2 = temp;
    return el;
  }

  public int peek() {
    while (queue1.size() > 1) {
      queue2.add(queue1.remove());
    }
    int el = queue1.remove();
    queue2.add(top);
    Queue<Integer> temp = queue1;
    queue1 = queue2;
    queue2 = temp;
    return el;
  }

  public boolean isEmpty() {
    return queue1.isEmpty();
  }

  public static void main(String[] args) {
    StackUsingQueues stack = new StackUsingQueues();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    System.out.println("Peek element: " + stack.peek());
    System.out.println("Popped element: " + stack.pop());
  }
}
