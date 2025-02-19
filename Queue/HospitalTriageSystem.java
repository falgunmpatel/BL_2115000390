import java.util.*;

class Patient {
  String name;
  int severity;

  public Patient(String name, int severity) {
    this.name = name;
    this.severity = severity;
  }

  @Override
  public String toString() {
    return name + " (Severity: " + severity + ")";
  }
}

public class HospitalTriageSystem {
  public static void main(String[] args) {
    Queue<Patient> triageQueue = new PriorityQueue<>(Comparator.comparingInt(p -> -p.severity));
    triageQueue.add(new Patient("John", 3));
    triageQueue.add(new Patient("Alice", 5));
    triageQueue.add(new Patient("Bob", 2));
    while (!triageQueue.isEmpty()) {
      System.out.println(triageQueue.remove());
    }
  }
}
