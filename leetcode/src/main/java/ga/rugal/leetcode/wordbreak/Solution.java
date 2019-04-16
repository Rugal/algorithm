package ga.rugal.leetcode.wordbreak;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-break/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public boolean wordBreak(final String s, final List<String> wordDict) {
    final Set<String> set = new HashSet<>(wordDict);
    final boolean[] result = new boolean[s.length() + 1];
    result[0] = true;

    for (int current = 1; current < result.length; ++current) {
      for (int i = 0; i < current; ++i) {
        //if string [0, i - 1] can be break into words, and string [i, current - 1] matches string
        if (result[i] && set.contains(s.substring(i, current))) {
          result[current] = true;
          break;
        }
      }
    }
    return result[s.length()];
  }
}
