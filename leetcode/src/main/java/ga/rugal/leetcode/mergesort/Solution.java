package ga.rugal.leetcode.mergesort;

/**
 *
 * @author Rugal Bernstein
 */
public class Solution {

  private int[] merge(final int[] a, final int[] b) {
    final int[] c = new int[a.length + b.length];
    int i = 0, j = 0;
    for (int k = 0; k < c.length; k++) {
      if (i >= a.length) {
        c[k] = b[j++];
        continue;
      }
      if (j >= b.length) {
        c[k] = a[i++];
        continue;
      }
      c[k] = a[i] <= b[j]
             ? a[i++]
             : b[j++];
    }
    return c;
  }

  public int[] mergesort(final int[] input) {
    if (input.length <= 1) {
      return input;
    }
    int[] a = new int[input.length / 2];
    int[] b = new int[input.length - input.length / 2];
    System.arraycopy(input, 0, a, 0, a.length);
    System.arraycopy(input, input.length / 2, b, 0, b.length);
    return merge(this.mergesort(a), this.mergesort(b));
  }
}
