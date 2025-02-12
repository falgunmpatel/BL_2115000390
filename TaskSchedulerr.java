import java.util.Scanner;

class Task {
  int taskId;
  String taskName;
  int priority;
  String dueDate;
  Task next;

  public Task(int taskId, String taskName, int priority, String dueDate) {
    this.taskId = taskId;
    this.taskName = taskName;
    this.priority = priority;
    this.dueDate = dueDate;
    this.next = null;
  }
}

class TaskScheduler {
  private Task head = null;
  private Task tail = null;
  private Task currentTask = null;

  public void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
    Task newTask = new Task(taskId, taskName, priority, dueDate);
    if (head == null) {
      head = tail = newTask;
      tail.next = head;
    } else {
      newTask.next = head;
      head = newTask;
      tail.next = head;
    }
  }

  public void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
    Task newTask = new Task(taskId, taskName, priority, dueDate);
    if (head == null) {
      head = tail = newTask;
      tail.next = head;
    } else {
      tail.next = newTask;
      tail = newTask;
      tail.next = head;
    }
  }

  public void addAtPosition(
      int taskId, String taskName, int priority, String dueDate, int position) {
    Task newTask = new Task(taskId, taskName, priority, dueDate);
    if (position <= 0) {
      System.out.println("Invalid position!");
      return;
    }
    if (position == 1) {
      addAtBeginning(taskId, taskName, priority, dueDate);
      return;
    }
    Task temp = head;
    for (int i = 1; temp != tail && i < position - 1; i++) {
      temp = temp.next;
    }
    newTask.next = temp.next;
    temp.next = newTask;
    if (temp == tail) {
      tail = newTask;
    }
    tail.next = head;
  }

  public void removeTask(int taskId) {
    if (head == null) {
      System.out.println("No tasks to remove.");
      return;
    }
    if (head.taskId == taskId) {
      if (head == tail) {
        head = tail = null;
      } else {
        head = head.next;
        tail.next = head;
      }
      System.out.println("Task removed successfully.");
      return;
    }
    Task temp = head, prev = null;
    do {
      if (temp.taskId == taskId) {
        prev.next = temp.next;
        if (temp == tail) {
          tail = prev;
        }
        tail.next = head;
        System.out.println("Task removed successfully.");
        return;
      }
      prev = temp;
      temp = temp.next;
    } while (temp != head);
    System.out.println("Task not found.");
  }

  public void viewAndMoveNext() {
    if (head == null) {
      System.out.println("No tasks available.");
      return;
    }
    if (currentTask == null) {
      currentTask = head;
    }
    System.out.println(
        "Current Task: ID="
            + currentTask.taskId
            + ", Name="
            + currentTask.taskName
            + ", Priority="
            + currentTask.priority
            + ", Due Date="
            + currentTask.dueDate);
    currentTask = currentTask.next;
  }

  public void displayAll() {
    if (head == null) {
      System.out.println("No tasks available.");
      return;
    }
    Task temp = head;
    do {
      System.out.println(
          "Task ID: "
              + temp.taskId
              + ", Name: "
              + temp.taskName
              + ", Priority: "
              + temp.priority
              + ", Due Date: "
              + temp.dueDate);
      temp = temp.next;
    } while (temp != head);
  }

  public void searchByPriority(int priority) {
    if (head == null) {
      System.out.println("No tasks available.");
      return;
    }
    Task temp = head;
    boolean found = false;
    do {
      if (temp.priority == priority) {
        System.out.println(
            "Found Task: ID="
                + temp.taskId
                + ", Name="
                + temp.taskName
                + ", Due Date="
                + temp.dueDate);
        found = true;
      }
      temp = temp.next;
    } while (temp != head);
    if (!found) {
      System.out.println("No task found with given priority.");
    }
  }
}

public class TaskSchedulerr {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    TaskScheduler taskScheduler = new TaskScheduler();

    while (true) {
      System.out.println("\nTask Scheduler (Circular Linked List)");
      System.out.println("1. Add Task at Beginning");
      System.out.println("2. Add Task at End");
      System.out.println("3. Add Task at Specific Position");
      System.out.println("4. Remove Task by ID");
      System.out.println("5. View and Move to Next Task");
      System.out.println("6. Display All Tasks");
      System.out.println("7. Search Task by Priority");
      System.out.println("8. Exit");
      System.out.print("Enter your choice: ");

      int choice = scanner.nextInt();
      switch (choice) {
        case 1:
          System.out.print("Enter Task ID: ");
          int id1 = scanner.nextInt();
          scanner.nextLine();
          System.out.print("Enter Task Name: ");
          String name1 = scanner.nextLine();
          System.out.print("Enter Priority: ");
          int priority1 = scanner.nextInt();
          scanner.nextLine();
          System.out.print("Enter Due Date: ");
          String dueDate1 = scanner.nextLine();
          taskScheduler.addAtBeginning(id1, name1, priority1, dueDate1);
          break;
        case 2:
          System.out.print("Enter Task ID: ");
          int id2 = scanner.nextInt();
          scanner.nextLine();
          System.out.print("Enter Task Name: ");
          String name2 = scanner.nextLine();
          System.out.print("Enter Priority: ");
          int priority2 = scanner.nextInt();
          scanner.nextLine();
          System.out.print("Enter Due Date: ");
          String dueDate2 = scanner.nextLine();
          taskScheduler.addAtEnd(id2, name2, priority2, dueDate2);
          break;
        case 3:
          System.out.print("Enter Task ID: ");
          int id3 = scanner.nextInt();
          scanner.nextLine();
          System.out.print("Enter Task Name: ");
          String name3 = scanner.nextLine();
          System.out.print("Enter Priority: ");
          int priority3 = scanner.nextInt();
          scanner.nextLine();
          System.out.print("Enter Due Date: ");
          String dueDate3 = scanner.nextLine();
          System.out.print("Enter Position: ");
          int position = scanner.nextInt();
          taskScheduler.addAtPosition(id3, name3, priority3, dueDate3, position);
          break;
        case 4:
          System.out.print("Enter Task ID to remove: ");
          int removeId = scanner.nextInt();
          taskScheduler.removeTask(removeId);
          break;
        case 5:
          taskScheduler.viewAndMoveNext();
          break;
        case 6:
          taskScheduler.displayAll();
          break;
        case 7:
          System.out.print("Enter Priority to search: ");
          int searchPriority = scanner.nextInt();
          taskScheduler.searchByPriority(searchPriority);
          break;
        case 8:
          System.out.println("Exiting Task Scheduler...");
          scanner.close();
          return;
        default:
          System.out.println("Invalid choice. Try again.");
      }
    }
  }
}
