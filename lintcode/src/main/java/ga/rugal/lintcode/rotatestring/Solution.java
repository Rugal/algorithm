package ga.rugal.lintcode.rotatestring;

/**
 * https://www.lintcode.com/problem/rotate-string/description
 *
 * @author Rugal Bernstein
 */
public class Solution {

  /**
   * @param str:    An array of char
   * @param offset: An integer
   *
   * @return: nothing
   */
  public void rotateString(char[] str, int offset) {
    // write your code here
    offset %= str.length;
    if (str.length == 0 || offset == 0) {
      return;
    }
    final char[] rest = new char[offset];
    for (int i = 0; i < offset; ++i) {
      rest[i] = str[str.length - offset + i];
    }
    for (int i = str.length - offset - 1; i >= 0; --i) {
      str[i + offset] = str[i];
    }
    for (int i = 0; i < offset; ++i) {
      str[i] = rest[i];
    }
  }
}
