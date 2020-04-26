package ga.rugal.leetcode.longestcommonsubsequence;

/**
 * https://leetcode.com/problems/longest-common-subsequence/
 *
 * @author rugal
 */
public class Solution {

  public int longestCommonSubsequence(final String word1, final String word2) {
    final char[] a1 = word1.toCharArray();
    final char[] a2 = word2.toCharArray();
    final int[][] dp = new int[a1.length][a2.length];
    dp[0][0] = a1[0] == a2[0] ? 1 : 0;
    for (int i = 1; i < a1.length; i++) {
      dp[i][0] = Math.max(a1[i] == a2[0] ? 1 : 0, dp[i - 1][0]);
    }
    for (int i = 1; i < a2.length; i++) {
      dp[0][i] = Math.max(a1[0] == a2[i] ? 1 : 0, dp[0][i - 1]);
    }
    for (int i = 1; i < a1.length; ++i) {
      for (int j = 1; j < a2.length; ++j) {
        dp[i][j] = a1[i] == a2[j]
                   ? dp[i - 1][j - 1] + 1
                   : Math.max(dp[i - 1][j], dp[i][j - 1]);
      }
    }
    return dp[a1.length - 1][a2.length - 1];
  }
}
