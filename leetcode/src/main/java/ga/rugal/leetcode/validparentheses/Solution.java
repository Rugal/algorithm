package ga.rugal.leetcode.validparentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  private final Map<Character, Character> map = new HashMap<>();

  public Solution() {
    this.map.put('(', ')');
    this.map.put('{', '}');
    this.map.put('[', ']');
  }

  public boolean isValid(String s) {

    final Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); ++i) {
      final char c = s.charAt(i);
      if (this.map.containsKey(c)) {
        stack.push(c);
        continue;
      }
      if (stack.isEmpty()
          || this.map.get(stack.peek()) != c) {
        return false;
      }
      stack.pop();
    }
    return stack.isEmpty();
  }
}
