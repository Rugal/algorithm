package ga.rugal.lintcode.fibonacci;

/**
 * https://www.lintcode.com/problem/fibonacci/description
 *
 * @author Rugal Bernstein
 */
public class Solution {

  /**
   * @param n: an integer
   *
   * @return : an integer f(n)
   */
  public int fibonacci(final int n) {
    // write your code here
    final int[] data = new int[2];
    data[0] = 0;
    data[1] = 1;
    if (n <= 2) {
      return data[n - 1];
    }
    for (int i = 2; i < n; ++i) {
      int temp = data[0] + data[1];
      data[0] = data[1];
      data[1] = temp;
    }
    return data[1];
  }
}
