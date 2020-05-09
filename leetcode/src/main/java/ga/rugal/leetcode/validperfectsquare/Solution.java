package ga.rugal.leetcode.validperfectsquare;

/**
 * https://leetcode.com/problems/valid-perfect-square/
 *
 * @author rugal
 */
public class Solution {

  public boolean isPerfectSquare(int num) {
    long begin = 1, end = num;
    while (begin <= end) {
      final long mid = (begin + end) / 2, result = mid * mid;
      if (result == num) {
        return true;
      }
      if (result < num) {
        begin = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return false;
  }
}
