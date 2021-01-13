package ga.rugal.amazon.maxconsecutiveonesiii;

/**
 * https://leetcode.com/problems/max-consecutive-ones-iii/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public int longestOnes(final int[] A, final int K) {
    if (A.length < 1) {
      return 0;
    }
    int max = 0, flip = 0;
    if (A[0] == 0) {
      ++flip;
    }
    for (int left = 0, right = 0;;) {
      if (flip <= K) {
        max = Math.max(max, right - left + 1);
      }
      if (right == A.length - 1 && flip <= K) {
        break;
      }

      if (flip > K) {
        if (0 == A[left++]) {
          --flip;
        }
      } else {
        if (0 == A[++right]) {
          ++flip;
        }
      }
    }
    return max;
  }
}
