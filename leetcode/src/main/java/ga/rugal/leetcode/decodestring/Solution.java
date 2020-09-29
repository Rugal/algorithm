package ga.rugal.leetcode.decodestring;

import java.util.Stack;

/**
 * https://leetcode.com/problems/decode-string/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  private static class Pair {

    public final int repetition;

    public final StringBuilder text;

    public Pair(final int repetition, final StringBuilder text) {
      this.repetition = repetition;
      this.text = text;
    }
  }

  /**
   * Decode string.
   *
   * @param s "3[a2[c]]"
   *
   * @return accaccacc
   */
  public String decodeString(final String s) {
    final Stack<Pair> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();
    int repetition = 0;
    for (int i = 0; i < s.length(); ++i) {
      final char c = s.charAt(i);
      if (Character.isDigit(c)) {
        repetition = repetition * 10 + (c - '0');
        continue;
      }
      if (Character.isAlphabetic(c)) {
        sb.append(c);
        continue;
      }
      if ('[' == c) {
        // any characters before [ and digits
        stack.push(new Pair(repetition, sb));
        repetition = 0;
        sb = new StringBuilder();
      } else {
        // start to compute the repetition within bracket and append it to the last string
        final Pair pop = stack.pop();
        sb = new StringBuilder(pop.text.toString() + sb.toString().repeat(pop.repetition));
      }
    }
    return sb.toString();
  }
}
