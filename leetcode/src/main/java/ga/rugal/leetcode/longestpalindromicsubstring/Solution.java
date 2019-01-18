package ga.rugal.leetcode.longestpalindromicsubstring;

/**
 * https://leetcode.com/problems/longest-palindromic-substring
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public String longestPalindrome(final String s) {
    if (s.isEmpty()) {
      return "";
    }
    String res = s.substring(0, 1);
    int currLength = 1;
    for (int i = 0; i < s.length(); i++) {
      if (this.isPalindrome(s, i - currLength - 1, i)) {
        res = s.substring(i - currLength - 1, i + 1);
        currLength += 2;
      } else if (this.isPalindrome(s, i - currLength, i)) {
        res = s.substring(i - currLength, i + 1);
        currLength++;
      }
    }
    return res;
  }

  private boolean isPalindrome(final String s, int begin, int end) {
    if (begin < 0) {
      return false;
    }
    while (begin < end) {
      if (s.charAt(begin++) != s.charAt(end--)) {
        return false;
      }
    }
    return true;
  }
}
