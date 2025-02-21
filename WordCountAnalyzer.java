import java.io.*;
import java.util.*;

public class WordCountAnalyzer {
  public static void main(String[] args) {
    String filePath = "source.txt";
    countWordsInFile(filePath);
  }

  private static void countWordsInFile(String filePath) {
    Map<String, Integer> wordCountMap = new HashMap<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] words = line.toLowerCase().split("\\W+");
        for (String word : words) {
          if (!word.isEmpty()) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
          }
        }
      }
    } catch (IOException e) {
      System.out.println("Error reading file: " + e.getMessage());
      return;
    }

    List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCountMap.entrySet());
    sortedWords.sort((a, b) -> b.getValue().compareTo(a.getValue()));
    System.out.println("Total words: " + wordCountMap.size());
    System.out.println("Top 5 most frequent words:");

    for (int i = 0; i < Math.min(5, sortedWords.size()); i++) {
      System.out.println(sortedWords.get(i).getKey() + ": " + sortedWords.get(i).getValue());
    }
  }
}
