public class StringConcatenationComparison {
  public static void main(String[] args) {
    int N = 10000;

    // String
    long startTime = System.nanoTime();
    String str = "";
    for (int i = 0; i < N; i++) {
      str += "a";
    }
    long stringTime = System.nanoTime() - startTime;

    // StringBuilder
    startTime = System.nanoTime();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      sb.append("a");
    }
    long stringBuilderTime = System.nanoTime() - startTime;

    // StringBuffer
    startTime = System.nanoTime();
    StringBuffer sbf = new StringBuffer();
    for (int i = 0; i < N; i++) {
      sbf.append("a");
    }
    long stringBufferTime = System.nanoTime() - startTime;

    System.out.println("Concatenation Performance for " + N + " iterations:");
    System.out.println("String Time: " + stringTime / 1_000_000.0 + " ms");
    System.out.println("StringBuilder Time: " + stringBuilderTime / 1_000_000.0 + " ms");
    System.out.println("StringBuffer Time: " + stringBufferTime / 1_000_000.0 + " ms");
  }
}
