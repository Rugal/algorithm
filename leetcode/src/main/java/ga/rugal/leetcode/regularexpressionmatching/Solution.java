package ga.rugal.leetcode.regularexpressionmatching;

/**
 * https://leetcode.com/problems/regular-expression-matching/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  private boolean in(final char value, final char[] target) {
    return value == target[0] || value == target[1];
  }

  public boolean isMatch(String text, String pattern) {
    return this.isMatch_dp(text, pattern);
  }

  public boolean isMatch_dp(String text, String pattern) {
    final var dp = new boolean[text.length() + 1][pattern.length() + 1];
    dp[text.length()][pattern.length()] = true;

    for (int i = text.length(); i >= 0; i--) {
      for (int j = pattern.length() - 1; j >= 0; j--) {
        final var first_match = i < text.length()
                            && this.in(pattern.charAt(j), new char[]{text.charAt(i), '.'});
        dp[i][j] = (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*')
                   ? dp[i][j + 2] || first_match && dp[i + 1][j]
                   : first_match && dp[i + 1][j + 1];
      }
    }
    return dp[0][0];
  }

  public boolean isMatch_recursive(String text, String pattern) {
    if (pattern.isEmpty()) {
      return text.isEmpty();
    }
    final var first_match = (!text.isEmpty()
                         && this.in(pattern.charAt(0), new char[]{text.charAt(0), '.'}));

    if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
      // if 2nd character is *
      return (isMatch(text, pattern.substring(2)) // skip the *, if the remaining match the patern after *
              // if first character matched, and the remaining matched as well
              || (first_match && isMatch(text.substring(1), pattern)));
    } else {
      // there is no *, and first character is matched, try matche the remaining string
      return first_match && isMatch(text.substring(1), pattern.substring(1));
    }
  }
}
