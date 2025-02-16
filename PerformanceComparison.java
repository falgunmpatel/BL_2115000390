import java.io.*;

public class PerformanceComparison {
  public static void main(String[] args) {
    compareStringBuilderAndStringBuffer();
    compareFileReaderAndInputStreamReader("large_file.txt");
  }

  private static void compareStringBuilderAndStringBuffer() {
    int iterations = 1_000_000;
    String text = "hello";

    // StringBuilder performance
    long startTime = System.nanoTime();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < iterations; i++) {
      sb.append(text);
    }
    long stringBuilderTime = System.nanoTime() - startTime;

    // StringBuffer performance
    startTime = System.nanoTime();
    StringBuffer sbf = new StringBuffer();
    for (int i = 0; i < iterations; i++) {
      sbf.append(text);
    }
    long stringBufferTime = System.nanoTime() - startTime;

    System.out.println("StringBuilder time: " + stringBuilderTime / 1_000_000 + " ms");
    System.out.println("StringBuffer time: " + stringBufferTime / 1_000_000 + " ms");
  }

  private static void compareFileReaderAndInputStreamReader(String filePath) {
    long startTime, fileReaderTime, inputStreamReaderTime;
    int wordCount = 0;

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      startTime = System.nanoTime();
      String line;
      while ((line = reader.readLine()) != null) {
        wordCount += line.split("\\s+").length;
      }
      fileReaderTime = System.nanoTime() - startTime;
      System.out.println("FileReader word count: " + wordCount);
      System.out.println("FileReader time: " + fileReaderTime / 1_000_000 + " ms");
    } catch (IOException e) {
      System.err.println("Error reading file with FileReader: " + e.getMessage());
    }

    wordCount = 0;

    // InputStreamReader performance
    try (BufferedReader reader =
        new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {
      startTime = System.nanoTime();
      String line;
      while ((line = reader.readLine()) != null) {
        wordCount += line.split("\\s+").length;
      }
      inputStreamReaderTime = System.nanoTime() - startTime;
      System.out.println("InputStreamReader word count: " + wordCount);
      System.out.println("InputStreamReader time: " + inputStreamReaderTime / 1_000_000 + " ms");
    } catch (IOException e) {
      System.err.println("Error reading file with InputStreamReader: " + e.getMessage());
    }
  }
}
