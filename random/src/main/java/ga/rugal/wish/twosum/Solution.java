package ga.rugal.wish.twosum;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/two-sum/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public int[] twoSum_1(final int[] nums, final int target) {
    final Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; ++i) {
      final int key = target - nums[i];
      if (map.containsKey(key) && i != map.get(key)) {
        return new int[]{map.get(key), i};
      }
      map.put(nums[i], i);
    }
    return null;
  }

  public int[] twoSum_2(final int[] nums, final int target) {
    final var map = IntStream.range(0, nums.length)
      .mapToObj(i -> i)
      .collect(Collectors.toMap(i -> nums[i], i -> i, (a, b) -> b));
    for (int i = 0; i < nums.length; ++i) {
      final int key = target - nums[i];
      if (map.containsKey(key) && i != map.get(key)) {
        return new int[]{map.get(key), i};
      }
      map.put(nums[i], i);
    }
    return null;
  }
}
