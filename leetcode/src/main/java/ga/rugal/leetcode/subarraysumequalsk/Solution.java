package ga.rugal.leetcode.subarraysumequalsk;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/subarray-sum-equals-k/
 *
 * @author rugal
 */
public class Solution {

  public int subarraySum(final int[] nums, final int k) {
    //sum, occur times
    final Map<Integer, Integer> map = new HashMap<>();
    int count = 0, sum = 0;
    map.put(0, 1);
    for (int n : nums) {
      sum += n;
      //this means the summation of element from [sum-k] and [sum] contribute to the "count"
      if (map.containsKey(sum - k)) {
        count += map.get(sum - k);
      }
      //in the case of cache hit, it's the second time that we get same sum - k.
      //that means between the summation the first and second hit is zero
      //so it can furtheir contribute to the future hit i---j-<0>-k
      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    return count;
  }
}
