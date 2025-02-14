import java.util.*;

class SortStack {

  public static void sortStack(Stack<Integer> stack) {
    if (!stack.isEmpty()) {
      int top = stack.pop();
      sortStack(stack);
      insertSorted(stack, top);
    }
  }

  private static void insertSorted(Stack<Integer> stack, int element) {
    if (stack.isEmpty() || stack.peek() <= element) {
      stack.push(element);
    } else {
      int top = stack.pop();
      insertSorted(stack, element);
      stack.push(top);
    }
  }

  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    stack.push(5);
    stack.push(1);
    stack.push(3);
    stack.push(7);
    stack.push(2);
    System.out.println("Original Stack: " + stack);
    sortStack(stack);
    System.out.println("Sorted Stack: " + stack);
  }
}
