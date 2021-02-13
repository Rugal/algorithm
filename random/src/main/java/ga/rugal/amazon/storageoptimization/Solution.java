package ga.rugal.amazon.storageoptimization;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/discuss/interview-question/1021429/Amazon-OA-or-storage-optimization
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public static long storage(int n, int m, List<Integer> h, List<Integer> v) {
    return 0;
  }

  private int max(final int length, final int[] reserve) {
    final Set<Integer> set = new HashSet<>(length);
    for (int i = 1; i < length; ++i) {
      set.add(i);
    }
    for (int i : reserve) {
      set.remove(i);
    }
    final int[] cuts = set.stream()
      .mapToInt(Integer::intValue)
      .toArray();

    if (cuts.length < 1) {
      return length;
    }
    // the initial cut
    int max = cuts[0];
    for (int i = 1; i < cuts.length; ++i) {
      max = Math.max(max, cuts[i] - cuts[i - 1]);
    }
    // compare the very last cut
    return Math.max(max, length - cuts[cuts.length - 1]);
  }

  public int storageOpt(final int n, final int m, final int[] h, final int[] v) {
    return this.max(n + 1, h) * this.max(m + 1, v);
  }
}
