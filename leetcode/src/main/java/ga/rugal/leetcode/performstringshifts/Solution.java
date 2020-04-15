package ga.rugal.leetcode.performstringshifts;

/**
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3299/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  /**
   * Shift character to the right.
   *
   * @param s string
   * @param n number to shift, must be positive
   *
   * @return
   */
  private String right(final String s, final int n) {
    return s.substring(s.length() - n) + s.substring(0, s.length() - n);
  }

  /**
   * Shift character to the left.
   *
   * @param s string
   * @param n number to shift, must be positive
   *
   * @return
   */
  private String left(final String s, final int n) {
    return s.substring(n) + s.substring(0, n);
  }

  public String stringShift(final String s, final int[][] shift) {
    int rightShift = 0;
    for (int[] command : shift) {
      rightShift += (command[0] * 2 - 1) * command[1];
    }
    rightShift %= s.length();

    return rightShift < 0
           ? this.left(s, rightShift * -1)
           : this.right(s, rightShift);
  }
}
