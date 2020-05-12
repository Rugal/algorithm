package ga.rugal.leetcode.buildanarraywithstackoperations;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/build-an-array-with-stack-operations/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  private static final String PUSH = "Push";

  private static final String POP = "Pop";

  public List<String> buildArray(final int[] t, final int n) {
    final List<String> l = new ArrayList<>();

    for (int i = 0, head = 1; i < t.length && head <= n; ++head) {
      l.add(PUSH);
      if (t[i] == head) {
        ++i;
      } else {
        l.add(POP);
      }
    }
    return l;
  }
}
