import java.util.Stack;

class QueueUsingTwoStack {
  Stack<Integer> stack1 = new Stack<>();
  Stack<Integer> stack2 = new Stack<>();

  public void enqueue(int data) {
    stack1.push(data);
  }

  public int dequeue() {
    if (stack2.isEmpty()) {
      if (stack1.isEmpty()) {
        throw new RuntimeException("Queue is empty!");
      }
      while (!stack1.isEmpty()) {
        stack2.push(stack1.pop());
      }
    }
    return stack2.pop();
  }

  public int peek() {
    if (stack2.isEmpty()) {
      if (stack1.isEmpty()) {
        throw new RuntimeException("Queue is empty!");
      }
      while (!stack1.isEmpty()) {
        stack2.push(stack1 pop());
      }
    }
    return stack2.peek();
  }

  public boolean isEmpty() {
    return stack1.isEmpty() && stack2.isEmpty();
  }

  public static void main(String[] args) {
    queueusingstack queue = new queueusingstack();
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    System.out.println(queue.dequeue());
    System.out.println(queue.peek());
    System.out.println(queue.dequeue());
    System.out.println(queue.isEmpty());
    System.out.println(queue.dequeue());
    System.out.println(queue.isEmpty());
  }
}
