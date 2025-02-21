import java.io.*;

public class FileCopy {
  public static void main(String[] args) {
    String sourceFile = "source.txt";
    String destinationFile = "destination.txt";

    try (FileInputStream fis = new FileInputStream(sourceFile);
        FileOutputStream fos = new FileOutputStream(destinationFile)) {
      int byteData;
      while ((byteData = fis.read()) != -1) {
        fos.write(byteData);
      }
      System.out.println("File copied successfully!");
    } catch (FileNotFoundException e) {
      System.out.println("Source file not found: " + e.getMessage());
    } catch (IOException e) {
      System.out.println("An error occurred while reading/writing the file: " + e.getMessage());
    }
  }
}
