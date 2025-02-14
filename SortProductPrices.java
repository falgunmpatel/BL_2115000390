import java.util.Arrays;

public class SortProductPrices {
  public static void quickSort(double[] prices, int low, int high) {
    if (low < high) {
      int partitionIndex = partition(prices, low, high);
      quickSort(prices, low, partitionIndex - 1);
      quickSort(prices, partitionIndex + 1, high);
    }
  }

  private static int partition(double[] prices, int low, int high) {
    double pivot = prices[high];
    int i = low - 1;

    for (int j = low; j < high; j++) {
      if (prices[j] <= pivot) {
        i++;
        double temp = prices[i];
        prices[i] = prices[j];
        prices[j] = temp;
      }
    }
    double temp = prices[i + 1];
    prices[i + 1] = prices[high];
    prices[high] = temp;

    return i + 1;
  }

  public static void main(String[] args) {
    double[] productPrices = {499.99, 349.50, 599.00, 199.75, 399.99, 299.99, 450.00};
    System.out.println("Original Product Prices-" + Arrays.toString(productPrices));
    quickSort(productPrices, 0, productPrices.length - 1);
    System.out.println("Sorted Product Prices-" + Arrays.toString(productPrices));
  }
}
