package ga.rugal.amazon.optimizatingboxweight;

import java.util.Arrays;

/**
 * https://leetcode.com/discuss/interview-question/1021441/Amazon-OA-or-optimizating-Box-Weight
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public int[] optimizeBoxWeight(final int[] arr) {
    final int total = Arrays.stream(arr).sum();
    Arrays.sort(arr);
    int sum = 0;
    int index = 0;
    for (; index < arr.length && 2 * sum <= total; ++index) {
      sum += arr[index];
    }
    --index;
    final int[] result = new int[arr.length - index];
    for (int i = 0; i < arr.length - index; ++i) {
      result[i] = arr[index + i];
    }
    return result;
  }
}
