import java.io.*;

public class ByteToCharacterStream {
  public static void main(String[] args) {
    String filePath = "sample.txt";
    try (BufferedReader reader =
        new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"))) {
      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
    } catch (IOException e) {
      System.err.println("Error reading file: " + e.getMessage());
    }
  }
}
