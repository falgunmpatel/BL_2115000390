public class LinearSearchWord {
  public static String findSentenceWithWord(String[] sentences, String word) {
    for (String sentence : sentences) {
      if (sentence.contains(word)) {
        return sentence;
      }
    }
    return "Not Found";
  }

  public static void main(String[] args) {
    String[] sentences = {
      "Java is a popular programming language.",
      "Data structures are important for coding interviews.",
      "This problem requires a linear search approach."
    };

    String wordToFind = "coding";
    String result = findSentenceWithWord(sentences, wordToFind);

    System.out.println("Sentence found: " + result);
  }
}
