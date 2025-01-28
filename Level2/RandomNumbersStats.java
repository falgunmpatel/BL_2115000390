import java.util.Arrays;

class RandomNumbersStats {

   public static int[] generate4DigitRandomArray(int size) {
      int[] randomNumbers = new int[size];
      for (int i = 0; i < size; i++) {
         randomNumbers[i] = (int) (Math.random() * 9000) + 1000;
      }
      return randomNumbers;
   }

   public static double[] findAverageMinMax(int[] numbers) {
      int sum = 0;
      int min = Integer.MAX_VALUE;
      int max = Integer.MIN_VALUE;

      for (int num : numbers) {
         sum += num;
         if (num < min) min = num;
         if (num > max) max = num;
      }

      double average = (double) sum / numbers.length;
      return new double[] { average, min, max };
   }

   public static void main(String[] args) {
      int[] randomNumbers = generate4DigitRandomArray(5);
      double[] stats = findAverageMinMax(randomNumbers);

      System.out.println("Random numbers: " + Arrays.toString(randomNumbers));
      System.out.println("Average: " + stats[0]);
      System.out.println("Min: " + stats[1]);
      System.out.println("Max: " + stats[2]);
   }
}
