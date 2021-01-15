package ga.rugal.amazon.romantointeger;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/roman-to-integer/
 *
 * @author rugal
 */
public class Solution {

  private final Map<Character, Integer> map = new HashMap<>();

  public Solution() {
    this.map.put('I', 1);
    this.map.put('V', 5);
    this.map.put('X', 10);
    this.map.put('L', 50);
    this.map.put('C', 100);
    this.map.put('D', 500);
    this.map.put('M', 1000);
  }

  public int romanToInt(final String s) {
    int result = 0;
    for (int i = 0; i < s.length(); ++i) {
      final char c = s.charAt(i);
      // regular number
      result += this.map.get(c);
      // case for subtraction
      result -= (i > 0 && this.map.get(s.charAt(i - 1)) < this.map.get(c)
                 ? 2 * this.map.get(s.charAt(i - 1))
                 : 0);
    }
    return result;
  }
}
