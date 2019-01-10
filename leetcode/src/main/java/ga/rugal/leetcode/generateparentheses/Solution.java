package ga.rugal.leetcode.generateparentheses;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rugal Bernstein
 */
public class Solution {

  private final List<String> list = new ArrayList<>();

  private int size = 0;

  public List<String> generateParenthesis(final int n) {
    this.size = n;
    list.clear();
    return this.backtrace("", 0, 0);
  }

  private List<String> backtrace(final String text, final int open, final int close) {
    if (open + close == this.size) {
      this.list.add(text);
      return this.list;
    }
    if (open < this.size) {
      this.backtrace(text + "(", open + 1, close);
    }
    if (close < open) {
      this.backtrace(text + ")", open, close + 1);
    }
    return this.list;
  }
}
