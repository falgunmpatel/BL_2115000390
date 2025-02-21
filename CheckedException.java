import java.io.*;

class CheckedException {
  public static void main(String[] args) {
    String Filename = "data.txt";

    try {
      BufferedReader reader = new BufferedReader(new FileReader(Filename));
      String line;

      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }

      reader.close();
    } catch (IOException e) {
      System.out.println("File not found");
    }
  }
}
