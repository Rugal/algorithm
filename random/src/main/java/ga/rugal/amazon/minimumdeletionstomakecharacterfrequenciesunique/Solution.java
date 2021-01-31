package ga.rugal.amazon.minimumdeletionstomakecharacterfrequenciesunique;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public int minDeletions(final String s) {
    final var count = new int[26];
    for (var c : s.toCharArray()) {
      ++count[c - 'a'];
    }
    final var sorted = Arrays.stream(count)
      .filter(c -> c > 0)
      .boxed()
      .sorted((a, b) -> b - a)
      .mapToInt(Integer::intValue)
      .toArray();
    int result = 0;
    for (int i = 1; i < sorted.length; ++i) {
      if (sorted[i - 1] > sorted[i]) {
        continue;
      }
      if (0 == sorted[i - 1]) {
        result += sorted[i];
        sorted[i] = 0;
      } else {
        final int target = sorted[i - 1] - 1;
        final int difference = sorted[i] - target;
        sorted[i] = target;
        result += difference;
      }
    }

    return result;
  }
}
