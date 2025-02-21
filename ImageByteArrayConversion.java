import java.io.*;

public class ImageByteArrayConversion {
  public static void main(String[] args) {
    String sourceImage = "source_image.jpg";
    String destinationImage = "copied_image.jpg";
    try {
      byte[] imageBytes = readImageToByteArray(sourceImage);
      writeByteArrayToImage(imageBytes, destinationImage);
      System.out.println("Image successfully copied!");
    } catch (IOException e) {
      System.out.println("An error occurred: " + e.getMessage());
    }
  }

  private static byte[] readImageToByteArray(String filePath) throws IOException {
    try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
        FileInputStream fis = new FileInputStream(filePath)) {
      byte[] buffer = new byte[4096];
      int bytesRead;
      while ((bytesRead = fis.read(buffer)) != -1) {
        baos.write(buffer, 0, bytesRead);
      }
      return baos.toByteArray();
    }
  }

  private static void writeByteArrayToImage(byte[] imageBytes, String filePath) throws IOException {
    try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
        FileOutputStream fos = new FileOutputStream(filePath)) {
      byte[] buffer = new byte[4096];
      int bytesRead;
      while ((bytesRead = bais.read(buffer)) != -1) {
        fos.write(buffer, 0, bytesRead);
      }
    }
  }
}
