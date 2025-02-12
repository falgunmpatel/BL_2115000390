import java.util.Scanner;

class TextNode {
  String content;
  TextNode prev, next;

  public TextNode(String content) {
    this.content = content;
    this.prev = this.next = null;
  }
}

class TextEditor {
  private TextNode head, tail, current;
  private final int MAX_HISTORY = 10;
  private int size = 0;

  public TextEditor() {
    head = tail = current = null;
  }

  public void addTextState(String content) {
    TextNode newNode = new TextNode(content);

    if (current != null) {
      current.next = newNode;
      newNode.prev = current;
    }

    current = newNode;

    if (head == null) head = tail = newNode;
    else tail = newNode;

    size++;
    if (size > MAX_HISTORY) {
      head = head.next;
      head.prev = null;
      size--;
    }
  }

  public void undo() {
    if (current == null || current.prev == null) {
      System.out.println("Undo not possible! No previous state.");
      return;
    }
    current = current.prev;
    System.out.println("Undo performed. Current state: " + current.content);
  }

  public void redo() {
    if (current == null || current.next == null) {
      System.out.println("Redo not possible! No next state.");
      return;
    }
    current = current.next;
    System.out.println("Redo performed. Current state: " + current.content);
  }

  public void displayCurrentState() {
    if (current == null) {
      System.out.println("Editor is empty!");
    } else {
      System.out.println("Current Text: " + current.content);
    }
  }
}

public class UndoRedoFunctionaltity {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    TextEditor editor = new TextEditor();

    while (true) {
      System.out.println("\nText Editor - Undo/Redo");
      System.out.println("1. Type New Text");
      System.out.println("2. Undo");
      System.out.println("3. Redo");
      System.out.println("4. Display Current Text");
      System.out.println("5. Exit");
      System.out.print("Enter choice: ");

      int choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1:
          System.out.print("Enter new text: ");
          String text = scanner.nextLine();
          editor.addTextState(text);
          break;
        case 2:
          editor.undo();
          break;
        case 3:
          editor.redo();
          break;
        case 4:
          editor.displayCurrentState();
          break;
        case 5:
          System.out.println("Exiting Text Editor...");
          scanner.close();
          return;
        default:
          System.out.println("Invalid choice! Try again.");
      }
    }
  }
}
