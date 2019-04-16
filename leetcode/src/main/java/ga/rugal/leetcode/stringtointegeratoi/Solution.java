package ga.rugal.leetcode.stringtointegeratoi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  /**
   * Regex approach.
   *
   * @param str
   *
   * @return
   */
  public int myAtoi(final String str) {
    final Matcher matcher = Pattern.compile("^\\s*[-+]?\\d+").matcher(str);
    if (!matcher.find()) {
      return 0;
    }
    final String text = matcher.group().trim();
    try {
      return Integer.parseInt(text);
    } catch (NumberFormatException e) {
      return text.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
    }
  }

  /**
   * Character approach.
   *
   * @param str
   *
   * @return
   */
  public int myAtoi2(final String str) {
    if (str.isEmpty()) {
      return 0;
    }
    final char[] string = str.toCharArray();
    int i = 0;
    while (i < string.length && string[i] == ' ') {
      i++;
    }
    if (i == string.length) {
      return 0;
    }

    boolean negative = false;
    if (string[i] == '-') {
      negative = true;
      i++;
    } else if (string[i] == '+') {
      i++;
    }
    int multiplier = 1;
    int num = 0;
    while (i < string.length && Character.isDigit(string[i])) {
      int digit = (int) string[i] - '0';
      digit = (negative ? 0 - digit : digit);
      final int newNum = num * multiplier + digit;
      final int testNum = (newNum - digit) / multiplier;
      //overflow will make the number irreversible, this is how we detect overflow
      if (!negative && (testNum != num || (newNum < 0))) {
        return Integer.MAX_VALUE;
      } else if (negative && (testNum != num || (newNum > 0))) {
        return Integer.MIN_VALUE;
      }
      num = newNum;
      if (multiplier == 1) {
        multiplier = 10;
      }
      i++;
    }
    return num;
  }
}
