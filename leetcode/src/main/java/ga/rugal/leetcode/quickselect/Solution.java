package ga.rugal.leetcode.quickselect;

public class Solution {

  private int[] list;

  private void swap(final int a, final int b) {
    final int temp = this.list[a];
    this.list[a] = this.list[b];
    this.list[b] = temp;
  }

  /**
   * Partition array from left to right relative to the value by pivotIndex.<BR>
   * smaller part to its left and larger part to its right.
   *
   * @param left
   * @param right
   * @param pivotIndex
   *
   * @return the rightmost element that smaller than pivot
   */
  private int partition(final int left, final int right, final int pivotIndex) {
    final int pivotValue = this.list[pivotIndex]; // store pivot value
    this.swap(pivotIndex, right); // Move pivot to the very right
    int index = left;
    for (int i = left; i < right; ++i) {
      if (this.list[i] < pivotValue) // Move element that is smaller than pivot to the left
      {
        this.swap(index++, i);
      }
    }
    // Now that index is the element that is the right most one that is smaller than pivot
    this.swap(right, index);
    return index;
  }

  private int select(final int left, final int right, int target) {
    if (left == right) {
      return this.list[left];
    }
    // Choose a good pivot index
    int pivot = right;
    pivot = this.partition(left, right, pivot);
    if (target == pivot) {
      return this.list[target];
    }
    return target < pivot
           // Keep searching the left part and the target is at the left as well
           ? this.select(left, pivot - 1, target)
           // The target is at the right
           // The first 'pivot' number of elements are in left
           // The last 'target - pivot' number of elements are in right
           : this.select(pivot + 1, right, target - pivot);
  }

  /**
   * Find No.k smallest element.
   *
   * @param list input data
   * @param k    No.k
   *
   * @return found element
   */
  public int quickSelect(final int[] list, final int k) {
    this.list = list;
    return this.select(0, list.length - 1, k);
  }

  public static void main(String[] args) {
    final Solution m = new Solution();
    final int[] list = new int[]{3, 2, 7, 5, 8, 9};
    final int k = 0;
    System.out.println(m.quickSelect(list, k));
  }
}
