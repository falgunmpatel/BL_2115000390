import java.util.*;

public class SortBookPrices {
  public static void mergeSort(int[] arr, int st, int en) {
    if (st < en) {
      int mid = st + (en - st) / 2;
      mergeSort(arr, st, mid);
      mergeSort(arr, mid + 1, en);
      mergeTwoSortedArrays(arr, st, mid, en);
    }
  }

  public static void mergeTwoSortedArrays(int[] arr, int st, int mid, int en) {
    int n1 = mid - st + 1;
    int n2 = en - mid;

    int[] leftArr = new int[n1];
    int[] rightArr = new int[n2];

    System.arraycopy(arr, st, leftArr, 0, n1);
    System.arraycopy(arr, mid + 1, rightArr, 0, n2);

    int i = 0;
    int j = 0;
    int k = st;
    while (i < n1 && j < n2) {
      if (leftArr[i] <= rightArr[j]) {
        arr[k++] = leftArr[i++];
      } else {
        arr[k++] = rightArr[j++];
      }
    }

    while (i < n1) {
      arr[k++] = leftArr[i++];
    }

    while (j < n2) {
      arr[k++] = rightArr[j++];
    }
  }

  public static void main(String[] args) {
    int[] bookPrices = {299, 399, 129, 229, 99, 119, 59, 69};
    mergeSort(bookPrices, 0, bookPrices.length - 1);
    System.out.println(Arrays.toString(bookPrices));
  }
}
