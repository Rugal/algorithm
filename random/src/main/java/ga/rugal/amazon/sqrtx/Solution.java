package ga.rugal.amazon.sqrtx;

/**
 * https://leetcode.com/problems/sqrtx/
 *
 * @author rugal
 */
public class Solution {

  /**
   * By using binary search, we quickly locate the right number.
   *
   * @param x
   *
   * @return
   */
  public int mySqrt(int x) {
    if (x == 0) {
      return 0;
    }
    int left = 1;
    for (int right = x; left < right;) {
      final int mid = (left + right) / 2;
      if (this.check(mid, x)) {
        return mid;
      }
      if (mid > x / mid) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

  /**
   * Check if the given number happens to be the square root of target
   *
   * @param i
   * @param target
   *
   * @return
   */
  private boolean check(final int i, final int target) {
    return (i <= target / i) && ((i + 1) > target / (i + 1));
  }
}
