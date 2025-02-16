import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordCountInFile {
  public static int countWordOccurrences(String filePath, String targetWord) {
    int count = 0;

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] words = line.split("\\s+");
        for (String word : words) {
          if (word.equals(targetWord)) {
            count++;
          }
        }
      }
    } catch (IOException e) {
      System.err.println("Error reading file: " + e.getMessage());
    }

    return count;
  }

  public static void main(String[] args) {
    String filePath = "sample.txt";
    String targetWord = "Java";

    int occurrences = countWordOccurrences(filePath, targetWord);
    System.out.println("The word \"" + targetWord + "\" appears " + occurrences + " times.");
  }
}
