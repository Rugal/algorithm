package ga.rugal.leetcode.stringtointegeratoi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public int myAtoi(String str) {
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
}
