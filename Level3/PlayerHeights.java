import java.util.*;
public class PlayerHeights {

    public static int[] generateRandomHeights() {
        int[] heights = new int[11];
        for (int i = 0; i < 11; i++) heights[i] = (int)(Math.random() * 101) + 150;
        return heights;
    }

    public static int findShortest(int[] heights) {
        return Arrays.stream(heights).min().orElse(-1);
    }

    public static int findTallest(int[] heights) {
        return Arrays.stream(heights).max().orElse(-1);
    }

    public static double findMean(int[] heights) {
        return Arrays.stream(heights).average().orElse(0.0);
    }

    public static void main(String[] args) {
        int[] heights = generateRandomHeights();
        System.out.println("Heights: " + Arrays.toString(heights));
        System.out.println("Shortest: " + findShortest(heights));
        System.out.println("Tallest: " + findTallest(heights));
        System.out.println("Mean: " + findMean(heights));
    }
}
