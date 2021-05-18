package ga.rugal.leetcode.wildcardmatching;

/**
 * https://leetcode.com/problems/wildcard-matching/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  private boolean in(final char value, final char target) {
    return value == target
           || value == '?'
           || value == '*';
  }

  public boolean isMatch(final String s, final String p) {
    return this.isMatch_dp(s, p);
  }

  public boolean isMatch_recursion(final String s, final String p) {
    if (p.isEmpty()) {
      return s.isEmpty();
    }

    final var firstMatch = (!s.isEmpty() && this.in(p.charAt(0), s.charAt(0)));

    return (!p.isEmpty() && p.charAt(0) == '*')
           ? this.isMatch(s, p.substring(1)) || firstMatch && this.isMatch(s.substring(1), p)
           : firstMatch && this.isMatch(s.substring(1), p.substring(1));
  }

  public boolean isMatch_dp(final String text, final String pattern) {
    final var dp = new boolean[text.length() + 1][pattern.length() + 1];
    dp[text.length()][pattern.length()] = true;

    for (int t = text.length(); t >= 0; t--) {
      for (int p = pattern.length() - 1; p >= 0; p--) {
        final var firstMatch = t < text.length() && this.in(pattern.charAt(p), text.charAt(t));
        dp[t][p] = (p < pattern.length() && pattern.charAt(p) == '*')
                   // if there is *
                   // either is last pattern also matched, as * matches all
                   // or this character matched, and last character match * as well
                   ? dp[t][p + 1] || firstMatch && dp[t + 1][p]
                   // if it is something else, ? or X
                   // this character must match, and the last character has to match last pattern
                   : firstMatch && dp[t + 1][p + 1];
      }
    }

    return dp[0][0];
  }
}
