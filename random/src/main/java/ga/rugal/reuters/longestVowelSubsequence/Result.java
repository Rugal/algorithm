package ga.rugal.reuters.longestVowelSubsequence;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Rugal Bernstein
 */
public class Result {

  /**
   * Complete the 'longestVowelSubsequence' function below.The function is expected to return an
   * INTEGER.The function accepts STRING s as parameter.
   *
   * @param s
   *
   * @return
   */
  public static int longestVowelSubsequence(String s) {
    final Map<Character, Integer> MAP = new HashMap<>();
    MAP.put('a', 0);
    MAP.put('e', 1);
    MAP.put('i', 2);
    MAP.put('o', 3);
    MAP.put('u', 4);

    int count = 0;
    int max = 0;
    int last = -1;

    for (char c : s.toCharArray()) {
      final int get = MAP.get(c);
      // the very initial
      if (-1 == last) {
        if (0 == get) {
          last = get;
          count = 1;
        }
        continue;
      }
      // keep the same character
      if (last == get) {
        ++count;
        if (4 == get) {
          max = Math.max(max, count);
        }
        continue;
      }
      // increment
      if (last + 1 == get) {
        last = get;
        ++count;
        if (4 == get) {
          max = Math.max(max, count);
        }
        continue;
      }
      // reset
      if (0 == get) {
        last = get;
        count = 1;
      } else {
        last = -1;
      }
    }

    return max;
  }
}
