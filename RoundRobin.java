import java.util.Scanner;

class Process {
  int processId;
  int burstTime;
  int priority;
  int waitingTime;
  int turnaroundTime;
  Process next;

  public Process(int processId, int burstTime, int priority) {
    this.processId = processId;
    this.burstTime = burstTime;
    this.priority = priority;
    this.waitingTime = 0;
    this.turnaroundTime = 0;
    this.next = null;
  }
}

class RoundRobinScheduler {
  private Process head = null;
  private Process tail = null;
  private int timeQuantum;

  public RoundRobinScheduler(int timeQuantum) {
    this.timeQuantum = timeQuantum;
  }

  public void addProcess(int processId, int burstTime, int priority) {
    Process newProcess = new Process(processId, burstTime, priority);
    if (head == null) {
      head = tail = newProcess;
      tail.next = head;
    } else {
      tail.next = newProcess;
      tail = newProcess;
      tail.next = head;
    }
  }

  public void simulateScheduling() {
    if (head == null) {
      System.out.println("No processes in the queue.");
      return;
    }

    Process current = head;
    int totalProcesses = countProcesses();
    int totalTime = 0;
    int[] remainingBurstTimes = new int[totalProcesses];
    Process temp = head;
    for (int i = 0; i < totalProcesses; i++) {
      remainingBurstTimes[i] = temp.burstTime;
      temp = temp.next;
    }

    System.out.println("\nStarting Round Robin Scheduling (Time Quantum = " + timeQuantum + ")");

    boolean processesRemaining = true;
    while (processesRemaining) {
      processesRemaining = false;
      Process prev = tail;

      for (int i = 0; i < totalProcesses; i++) {
        if (remainingBurstTimes[i] > 0) {
          processesRemaining = true;
          int timeSlice = Math.min(timeQuantum, remainingBurstTimes[i]);
          System.out.println(
              "Process " + current.processId + " executing for " + timeSlice + " units.");

          remainingBurstTimes[i] -= timeSlice;
          totalTime += timeSlice;
          if (remainingBurstTimes[i] == 0) {
            current.turnaroundTime = totalTime;
            current.waitingTime = current.turnaroundTime - current.burstTime;
            System.out.println(
                "Process "
                    + current.processId
                    + " completed. Turnaround Time: "
                    + current.turnaroundTime
                    + ", Waiting Time: "
                    + current.waitingTime);
          }

          prev = current;
          current = current.next;
        }
      }
    }
    displayAverageTimes();
  }

  public void removeProcess(int processId) {
    if (head == null) {
      System.out.println("No processes in the queue.");
      return;
    }
    Process temp = head, prev = null;
    if (head.processId == processId) {
      tail.next = head.next;
      head = head.next;
      System.out.println("Process " + processId + " removed after execution.");
      return;
    }
    do {
      prev = temp;
      temp = temp.next;
      if (temp.processId == processId) {
        prev.next = temp.next;
        if (temp == tail) {
          tail = prev;
        }
        System.out.println("Process " + processId + " removed after execution.");
        return;
      }
    } while (temp != head);
  }

  public void displayProcesses() {
    if (head == null) {
      System.out.println("No processes in the queue.");
      return;
    }
    Process temp = head;
    System.out.println("\nProcesses in the queue:");
    do {
      System.out.println(
          "Process ID: "
              + temp.processId
              + ", Burst Time: "
              + temp.burstTime
              + ", Priority: "
              + temp.priority);
      temp = temp.next;
    } while (temp != head);
  }

  private int countProcesses() {
    if (head == null) return 0;
    int count = 0;
    Process temp = head;
    do {
      count++;
      temp = temp.next;
    } while (temp != head);
    return count;
  }

  private void displayAverageTimes() {
    int totalWaitingTime = 0;
    int totalTurnaroundTime = 0;
    int count = countProcesses();

    Process temp = head;
    do {
      totalWaitingTime += temp.waitingTime;
      totalTurnaroundTime += temp.turnaroundTime;
      temp = temp.next;
    } while (temp != head);

    System.out.println("\nAverage Waiting Time: " + (double) totalWaitingTime / count);
    System.out.println("Average Turnaround Time: " + (double) totalTurnaroundTime / count);
  }
}

public class RoundRobin {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter Time Quantum: ");
    int timeQuantum = scanner.nextInt();
    RoundRobinScheduler scheduler = new RoundRobinScheduler(timeQuantum);
    while (true) {
      System.out.println("\nRound Robin Scheduling System");
      System.out.println("1. Add Process");
      System.out.println("2. Simulate Scheduling");
      System.out.println("3. Display Processes");
      System.out.println("4. Remove Process");
      System.out.println("5. Exit");
      System.out.print("Enter choice: ");

      int choice = scanner.nextInt();
      switch (choice) {
        case 1:
          System.out.print("Enter Process ID: ");
          int processId = scanner.nextInt();
          System.out.print("Enter Burst Time: ");
          int burstTime = scanner.nextInt();
          System.out.print("Enter Priority: ");
          int priority = scanner.nextInt();
          scheduler.addProcess(processId, burstTime, priority);
          break;
        case 2:
          scheduler.simulateScheduling();
          break;
        case 3:
          scheduler.displayProcesses();
          break;
        case 4:
          System.out.print("Enter Process ID to remove: ");
          int removeId = scanner.nextInt();
          scheduler.removeProcess(removeId);
          break;
        case 5:
          System.out.println("Exiting...");
          scanner.close();
          return;
        default:
          System.out.println("Invalid choice. Try again.");
      }
    }
  }
}
