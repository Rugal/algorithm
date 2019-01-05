package ga.rugal.leetcode.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public List<List<Integer>> threeSum(int[] nums) {

    final List<List<Integer>> result = new ArrayList<>();

    if (null == nums || nums.length < 3) {
      return result;
    }

    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2;) {
      if (nums[i] > 0) {
        break;
      }
      for (int left = i + 1, right = nums.length - 1; left < right;) {
        final int sum = nums[i] + nums[left] + nums[right];
        if (sum == 0) {
          result.add(Arrays.asList(nums[i], nums[left], nums[right]));
        }
        if (sum <= 0) {
          while (nums[left] == nums[++left] && left < right);
        }
        if (sum >= 0) {
          //java always uses new value from memory
          while (nums[right--] == nums[right] && left < right);
        }
      }
      while (nums[i] == nums[++i] && i < nums.length - 2);
    }
    return result;
  }
}
