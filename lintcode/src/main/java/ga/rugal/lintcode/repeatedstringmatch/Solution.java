package ga.rugal.lintcode.repeatedstringmatch;

/**
 * https://www.lintcode.com/problem/repeated-string-match/description
 *
 * @author Rugal Bernstein
 */
public class Solution {

  /**
   * @param a: a string
   * @param b: a string
   *
   * @return
   *
   * @return: return an integer
   */
  public int repeatedStringMatch(String a, String b) {
    // write your code here
    StringBuilder sb = new StringBuilder();
    while (sb.length() < b.length()) {
      sb.append(a);
    }
    if (sb.toString().contains(b)) {
      return sb.length() / a.length();
    }
    return sb.append(a).toString().contains(b)
           ? sb.length() / a.length()
           : - 1;
  }
}
