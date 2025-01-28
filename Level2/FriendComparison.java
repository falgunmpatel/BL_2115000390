import java.util.Scanner;

class FriendComparison {

   public static String findYoungest(int[] ages, String[] names) {
      int minAge = Integer.MAX_VALUE;
      String youngest = "";
      for (int i = 0; i < ages.length; i++) {
         if (ages[i] < minAge) {
            minAge = ages[i];
            youngest = names[i];
         }
      }
      return youngest;
   }

   public static String findTallest(double[] heights, String[] names) {
      double maxHeight = -1;
      String tallest = "";
      for (int i = 0; i < heights.length; i++) {
         if (heights[i] > maxHeight) {
            maxHeight = heights[i];
            tallest = names[i];
         }
      }
      return tallest;
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      String[] names = {"Amar", "Akbar", "Anthony"};
      int[] ages = new int[3];
      double[] heights = new double[3];

      for (int i = 0; i < 3; i++) {
         System.out.print("Enter " + names[i] + "'s age: ");
         ages[i] = scanner.nextInt();
         System.out.print("Enter " + names[i] + "'s height: ");
         heights[i] = scanner.nextDouble();
      }

      System.out.println("Youngest friend: " + findYoungest(ages, names));
      System.out.println("Tallest friend: " + findTallest(heights, names));
   }
}
