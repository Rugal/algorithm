package ga.rugal.leetcode.isomorphicstrings;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/isomorphic-strings/
 *
 * @author rugal
 */
public class Solution {

  public boolean isIsomorphic(final String s, final String t) {
    return translate(s) == translate(t);
  }

  private int translate(final String text) {
    final Map<Character, Integer> map = new HashMap<>();
    int base = 0; // 0 for string that never duplicate character
    for (int i = 0; i < text.length(); i++) {
      if (map.containsKey(text.charAt(i))) {
        // if we saw this character already, means current character is a duplication
        // basically hash this string by calculating an decimal value
        // the key is to know the location of duplication
        // then calculate the hash value based on that
        // also shift by factor 10 to emphasis the importance of order
        base = base * 10 + map.get(text.charAt(i));
      } else {
        // if we never seen this char before
        // the key point is: what character is located at where
        // simply record index of each character in map
        map.put(text.charAt(i), i + 1); // +1 for escaping index 0
      }
    }
    return base;
  }
}
