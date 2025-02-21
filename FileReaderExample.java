import java.io.*;

public class FileReaderExample {
  public static void main(String[] args) {
    String filename = "info.txt";

    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String firstLine = reader.readLine();

      if (firstLine != null) {
        System.out.println("First line: " + firstLine);
      } else {
        System.out.println("File is empty.");
      }
    } catch (IOException e) {
      System.out.println("Error reading file");
    }
  }
}
