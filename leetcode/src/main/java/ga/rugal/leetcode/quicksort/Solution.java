package ga.rugal.leetcode.quicksort;

/**
 *
 * @author Rugal Bernstein
 */
public class Solution {

  /**
   *
   * @param arr
   */
  public void quickSort(final int arr[]) {
    this.quickSort(arr, 0, arr.length - 1);
  }

  private void quickSort(final int arr[], final int begin, final int end) {
    if (begin < end) {
      final int partitionIndex = partition(arr, begin, end);

      quickSort(arr, begin, partitionIndex - 1);
      quickSort(arr, partitionIndex + 1, end);
    }
  }

  private int partition(final int arr[], final int begin, final int end) {
    final int pivot = arr[end];
    int i = (begin - 1);//first number at left that is greater than pivot

    for (int j = begin; j < end; j++) {
      if (arr[j] <= pivot) {
        i++;

        final int swapTemp = arr[i];
        arr[i] = arr[j];
        arr[j] = swapTemp;
      }
    }

    final int swapTemp = arr[i + 1];
    arr[i + 1] = arr[end];
    arr[end] = swapTemp;

    return i + 1;
  }
}
