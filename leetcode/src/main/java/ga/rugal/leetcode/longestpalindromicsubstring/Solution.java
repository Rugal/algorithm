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
    String result = s.substring(0, 1);
    int currentLength = 1;
    for (int i = 0; i < s.length(); i++) {
      //first try with 2 more characters X??
      if (this.isPalindrome(s, i - currentLength - 1, i)) {
        //first substring
        result = s.substring(i - currentLength - 1, i + 1);
        //then update palindrome length
        currentLength += 2;
        continue;
      }
      //if 2 not works, try with 1 more character X?
      if (this.isPalindrome(s, i - currentLength, i)) {
        result = s.substring(i - currentLength, i + 1);
        currentLength++;
      }
    }
    return result;
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
