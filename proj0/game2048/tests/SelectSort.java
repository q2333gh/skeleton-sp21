package game2048.tests;

/**
 * @author q2333
 * @date 2022/10/05 15:58
 **/
public class SelectSort {
  public static int findSmallestIndex(final int[] a, final int from) {
    int smallestIndex = from;
    int smallest = a[from];
    for (int i = 1 + from; i < a.length; i++) {
      if (a[i] < smallest) {
        smallestIndex = i;
        smallest = a[i];
      }
    }
    return smallestIndex;
  }

  public static void swap(int[] a, int i, int j) {
    int tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }

  public static void selectSort(int[] a) {
    for (int i = 0; i < a.length; i++) {
      int smallestIndex = findSmallestIndex(a, i);
      swap(a, i, smallestIndex);
    }
  }

  public static void printArray(int[] a) {
    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i]+" ");
    }
  }

}
