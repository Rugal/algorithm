package ga.rugal.leetcode.sortcharactersbyfrequency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/sort-characters-by-frequency/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public String frequencySort(final String s) {
    final var map = new HashMap<Character, Integer>(s.length());
    for (char c : s.toCharArray()) {
      final Integer value = map.getOrDefault(c, 0);
      map.put(c, value + 1);
    }

    final var list = new ArrayList<Map.Entry<Character, Integer>>(map.entrySet());
    list.sort((a, b) -> b.getValue() - a.getValue());
    return list.stream()
      .map(a -> a.getKey().toString().repeat(a.getValue()))
      .reduce("", (a, b) -> a + b);
  }
}
