package ga.rugal.amazon.wordbreakii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-break-ii/
 *
 * @author rugal
 */
public class Solution {

  private Set<String> candidates;

  private final Map<String, List<String>> cache = new HashMap<>();

  /**
   * To enhance performance, here we use map to cache repeated result.
   *
   * @param s
   * @param wordDict
   *
   * @return
   */
  public List<String> wordBreak(String s, List<String> wordDict) {
    if (s.length() == 0) {
      return new ArrayList<>();
    }

    this.candidates = new HashSet<>(wordDict);
    return this.dfs(s);
  }

  private List<String> dfs(final String s) {
    if (this.cache.containsKey(s)) {
      return this.cache.get(s);
    }
    final List<String> result = new ArrayList<>();
    if (this.candidates.contains(s)) {
      // add to result if this substring is in word candidates
      result.add(s);
    }

    // now try to split the string
    for (int i = 1; i < s.length(); ++i) {
      // try everything single prefix combination
      final var prefix = s.substring(0, i);
      if (!this.candidates.contains(prefix)) {
        // skip if the prefix is not a candidate, we want every substring a candidate
        continue;
      }
      // now we want the suffix part to match somehow
      // only add if the suffix has complete match as well
      for (var r : this.dfs(s.substring(i))) {
        // if there is any match, combine them back and add to the result
        result.add(prefix + " " + r);
      }
    }
    // cache the string:break pair
    // we have gone through the all the possible combination of string s, now cache it and return
    this.cache.put(s, result);
    return result;
  }
}
