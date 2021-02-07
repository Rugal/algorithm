package ga.rugal.amazon.primeairtime;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/discuss/interview-question/1025705/Amazon-or-OA-or-Prime-Air-time
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public List<int[]> getPair(final int[][] A, final int[][] B, final int target) {
    int sum = -1;
    final List<int[]> result = new ArrayList<>();
    for (int[] a : A) {
      for (int[] b : B) {
        final int s = a[1] + b[1];
        if (s > target || s < sum) {
          continue;
        }
        if (s > sum) {
          result.clear();
          sum = s;
        }
        result.add(new int[]{a[0], b[0]});
      }
    }
    return result;
  }
}
