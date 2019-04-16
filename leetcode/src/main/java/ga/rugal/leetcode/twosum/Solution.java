package ga.rugal.leetcode.twosum;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public int[] twoSum(final int[] nums, final int target) {
    final Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; ++i) {
      final int key = target - nums[i];
      if (map.containsKey(key) && i != map.get(key)) {
        //current value i should be placed at second slot
        //as when key is store before i
        return new int[]{map.get(key), i};
      }
      map.put(nums[i], i);
    }
    return null;
  }
}
