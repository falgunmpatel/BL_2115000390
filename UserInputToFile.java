import java.io.*;

public class UserInputToFile {
  public static void main(String[] args) {
    String filePath = "output.txt";

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

      System.out.println("Enter text (type 'exit' to stop):");
      String line;

      while (!(line = reader.readLine()).equalsIgnoreCase("exit")) {
        writer.write(line);
        writer.newLine();
      }

      System.out.println("User input saved to " + filePath);
    } catch (IOException e) {
      System.err.println("Error processing input/output: " + e.getMessage());
    }
  }
}
