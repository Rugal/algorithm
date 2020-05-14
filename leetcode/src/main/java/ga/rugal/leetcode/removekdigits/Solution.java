package ga.rugal.leetcode.removekdigits;

/**
 * https://leetcode.com/problems/remove-k-digits/
 *
 * @author rugal
 */
public class Solution {

  /**
   * Get the prefix string that is minimum.<BR>
   * make sure the new char is not bigger that the very last character.
   *
   * @param num
   * @param k
   * @param result
   *
   * @return [the first character to append if not all string appended, number of digits left to
   *         remove]
   */
  private int[] getMinimumPrefix(final String num, int k, final StringBuilder result) {
    final char[] array = num.toCharArray();
    int i = 0;
    while (i < array.length && k > 0) {
      final char current = array[i];
      if (result.length() == 0) {
        ++i;
        result.append(current);
        continue;
      }
      final char last = result.charAt(result.length() - 1);
      if (last <= current) {
        ++i;
        result.append(current);
        continue;
      }
      result.deleteCharAt(result.length() - 1);
      --k;
    }
    return new int[]{i, k};
  }

  /**
   * Remove all prefix zero from this String.<BR>
   * We would have used "Integer.parse", but because input data can be overflow, we have to use this
   * method to trim prefix zero.
   *
   * @param input
   *
   * @return
   */
  private StringBuilder trimPrefixZero(final StringBuilder input) {
    final StringBuilder sb = new StringBuilder();
    boolean prefixZero = true;
    for (int i = 0; i < input.length(); ++i) {
      if (input.charAt(i) != '0') {
        prefixZero = false;
        sb.append(input.charAt(i));
        continue;
      }
      if (!prefixZero) {
        sb.append(input.charAt(i));
      }
    }
    return sb;
  }

  public String removeKdigits(final String num, int k) {
    // return 0 if we have to remove all digits
    if (k >= num.length()) {
      return "0";
    }
    final StringBuilder sb = new StringBuilder();
    // get minimum prefix string
    final int[] result = this.getMinimumPrefix(num, k, sb);
    // append rest of string to result if not all string are appended
    sb.append(num.substring(result[0]));
    // trim prefix zero, not valid in integer world
    final StringBuilder a = this.trimPrefixZero(sb);
    // remove last several digit if not all k digits are removed
    final String s = a.substring(0, a.length() - result[1]);
    // possible that string is empty after removal of last few character then return 0 by default
    return s.isEmpty() ? "0" : s;
  }
}
