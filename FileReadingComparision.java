import java.io.*;

public class FileReadingComparison {
  public static void main(String[] args) {
    String filePath = "./sample.txt";

    // Using FileReader to read a text file
    long startTime = System.nanoTime();

    try (FileReader fileReader = new FileReader(filePath)) {
      while (fileReader.read() != -1) {}
    } catch (IOException e) {
      e.printStackTrace();
    }

    long fileReaderTime = System.nanoTime() - startTime;

    // Using InputStreamReader to read a text file
    startTime = System.nanoTime();

    try (InputStreamReader inputStreamReader =
        new InputStreamReader(new FileInputStream(filePath))) {
      while (inputStreamReader.read() != -1) {}
    } catch (IOException e) {
      e.printStackTrace();
    }

    long inputStreamReaderTime = System.nanoTime() - startTime;

    System.out.println("File Reading Performance for " + filePath + ":");
    System.out.println("FileReader Time: " + (fileReaderTime / 1_000_000.0) + " ms");
    System.out.println("InputStreamReader Time: " + (inputStreamReaderTime / 1_000_000.0) + " ms");
  }
}
