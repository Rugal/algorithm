package ga.rugal.leetcode.longestsubstringwithoutrepeatingcharacters;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public int lengthOfLongestSubstring(final String s) {
    final Map<Character, Integer> map = new HashMap<>(s.length());
    int max = 0;
    for (int current = 0, start = 0; current < s.length(); ++current) {
      final char c = s.charAt(current);
      //if contains duplicate key
      //which means the last longest substring ends here
      if (map.containsKey(c)) {
        //then update the start index of new longest substring
        //either +1 of last start index, or
        start = Math.max(map.get(c) + 1, // for "aba..." case
                         start); // for "abb..."
      }
      max = Math.max(max, current - start + 1);
      map.put(c, current);
    }
    return max;
  }
}
