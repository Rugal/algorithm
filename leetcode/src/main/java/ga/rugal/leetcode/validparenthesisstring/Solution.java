package ga.rugal.leetcode.validparenthesisstring;

/**
 * https://leetcode.com/problems/valid-parenthesis-string/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public boolean checkValidString(final String s) {
    int lower = 0, upper = 0;
    for (int i = 0; i < s.length(); ++i) {
      final char c = s.charAt(i);
      // lower bound can only be incremented by (, otherwise will decrement but always be non-negative
      lower += c == '(' ? 1 : -1;
      // upper bound can be decremented by ), otherwise will increment
      upper += c == ')' ? -1 : 1;
      // if upper bound is negative means there is no way to balance the parenthesis at all
      if (upper < 0) {
        break;
      }
      // to set non-negative
      lower = Math.max(lower, 0);
    }
    return lower == 0;
  }
}
