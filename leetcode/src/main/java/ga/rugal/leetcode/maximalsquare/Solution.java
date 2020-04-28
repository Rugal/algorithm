package ga.rugal.leetcode.maximalsquare;

/**
 * https://leetcode.com/problems/maximal-square/
 *
 * @author rugal
 */
public class Solution {

  private int min(final int a, final int b, final int c) {
    return Math.min(Math.min(a, b), c);
  }

  public int maximalSquare(final char[][] map) {
    if (map.length == 0) {
      return 0;
    }
    int result = 0;
    final int[][] dp = new int[map.length + 1][map[0].length + 1];
    for (int i = 1; i <= map.length; i++) {
      for (int j = 1; j <= map[0].length; j++) {
        if (map[i - 1][j - 1] == '1') {
          dp[i][j] = this.min(dp[i][j - 1], dp[i - 1][j - 1], dp[i - 1][j]) + 1;
          result = Math.max(dp[i][j], result); // update result
        }
      }
    }
    return result * result;
  }
}
