package ga.rugal.leetcode.longestsubstringwithoutrepeatingcharacters;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public int lengthOfLongestSubstring(final String s) {
    final Map<Character, Integer> map = new HashMap<>(s.length());
    int max = 0;
    for (int current = 0, start = 0; current < s.length(); ++current) {
      final char c = s.charAt(current);
      //a duplicate occurs, we need to move head to the right
      if (map.containsKey(c)) {
        //but to which extend?
        start = Math.max(map.get(c) + 1, // for "aba..." case, move to the b
                         start); // for "abba...", move to the second b
      }
      max = Math.max(max, current - start + 1);
      map.put(c, current);
    }
    return max;
  }
}
