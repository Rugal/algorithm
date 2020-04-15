package ga.rugal.leetcode.contiguousarray;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/contiguous-array/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public int findMaxLength(final int[] nums) {
    final Map<Integer, Integer> map = new HashMap<>(2 * nums.length + 1);
    map.put(0, -1);
    int sum = 0;
    int max = 0;
    for (int i = 0; i < nums.length; ++i) {
      sum += (nums[i] * 2 - 1);
      if (map.containsKey(sum)) {
        max = Math.max(max, i - map.get(sum));
      } else {
        map.put(sum, i);
      }
    }
    return max;
  }
}
