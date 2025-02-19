import java.util.*;

public class WordFrequencyCounter {
  public static void main(String[] args) {
    String filePath = "path/to/your/textfile.txt";
    Map<String, Integer> wordFrequency = countWordFrequency(filePath);
    System.out.println(wordFrequency);
  }

  public static Map<String, Integer> countWordFrequency(String filePath) {
    Map<String, Integer> wordFrequency = new HashMap<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] words = line.toLowerCase().replaceAll("[^a-zA-Z0-9 ]", "").split("\\s+");
        for (String word : words) {
          wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return wordFrequency;
  }
}
