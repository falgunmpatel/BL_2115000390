import java.io.*;

public class FileCopyComparision {
  public static void main(String[] args) {
    String sourceFile = "source.txt";
    String destinationFile = "destination.txt";

    long startTime, endTime;
    try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
        BufferedOutputStream bos =
            new BufferedOutputStream(new FileOutputStream(destinationFile))) {
      byte[] buffer = new byte[4096];
      int bytesRead;
      startTime = System.nanoTime();
      while ((bytesRead = bis.read(buffer)) != -1) {
        bos.write(buffer, 0, bytesRead);
      }
      endTime = System.nanoTime();
      System.out.println(
          "Buffered Streams Copy Time: " + (endTime - startTime) / 1_000_000 + " ms");
    } catch (FileNotFoundException e) {
      System.out.println("Source file not found: " + e.getMessage());
    } catch (IOException e) {
      System.out.println("An error occurred while reading/writing the file: " + e.getMessage());
    }

    try (FileInputStream fis = new FileInputStream(sourceFile);
        FileOutputStream fos = new FileOutputStream(destinationFile)) {
      int byteData;
      startTime = System.nanoTime();
      while ((byteData = fis.read()) != -1) {
        fos.write(byteData);
      }
      endTime = System.nanoTime();
      System.out.println(
          "Unbuffered Streams Copy Time: " + (endTime - startTime) / 1_000_000 + " ms");
    } catch (FileNotFoundException e) {
      System.out.println("Source file not found: " + e.getMessage());
    } catch (IOException e) {
      System.out.println("An error occurred while reading/writing the file: " + e.getMessage());
    }
  }
}
