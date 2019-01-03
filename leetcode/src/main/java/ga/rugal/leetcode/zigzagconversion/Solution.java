package ga.rugal.leetcode.zigzagconversion;

/**
 *
 * @author Rugal Bernstein
 */
public class Solution {

  /**
   *
   * @param s
   * @param numRows
   *
   * @return
   */
  public String convert(final String s, final int numRows) {
    if (1 == numRows) {
      return s;
    }

    final StringBuilder sb = new StringBuilder();
    final int cycle = 2 * numRows - 2;
    for (int row = 0; row < numRows; ++row) {
      for (int column = 0; row + column < s.length(); column += cycle) {
        sb.append(s.charAt(row + column));
        if (row > 0 && row < numRows - 1 && column + cycle - row < s.length()) {
          sb.append(s.charAt(column + cycle - row));
        }
      }
    }

    return sb.toString();
  }
}
