package ga.rugal.amazon.minimumaddtomakeparenthesesvalid;

import java.util.Stack;

/**
 * https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public int minAddToMakeValid_stack(final String S) {
    var s = new Stack<Character>();
    for (var c : S.toCharArray()) {
      if (s.isEmpty() || c == '(') {
        s.push(c);
        continue;
      }
      // now c == ')'
      if (s.peek() == '(') {
        s.pop();
      } else {
        s.push(')');
      }
    }

    return s.size();
  }

  public int minAddToMakeValid_counter(String S) {
    int right = 0, left = 0;
    for (var c : S.toCharArray()) {
      // the number of unpaired left parenthesis
      left += c == '(' ? 1 : -1;
      // It is guaranteed bal >= -1
      if (left == -1) {
        // the number of unpaired right parenthesis
        right++;
        left = 0;
      }
    }
    // summation of unpaired left + right parenthesis
    return right + left;
  }
}
