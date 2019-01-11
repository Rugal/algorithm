package ga.rugal.leetcode.groupanagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/group-anagrams/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public List<List<String>> groupAnagrams(String[] strs) {
    final Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      char[] chars = str.toCharArray();
      Arrays.sort(chars);
      final String key = String.valueOf(chars);
      List<String> get = map.get(key);
      if (null == get) {
        get = new ArrayList<>();
        map.put(key, get);
      }
      get.add(str);
    }

    return map.values().stream()
      .collect(Collectors.toList());
  }
}
