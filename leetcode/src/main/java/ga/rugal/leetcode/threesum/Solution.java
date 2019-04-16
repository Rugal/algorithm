package ga.rugal.leetcode.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  /**
   * Fix one number and move the other 2 pointers according to the relative size.
   *
   * @param nums
   *
   * @return
   */
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
          //move all the way to right if the number is the same
          while (nums[left] == nums[++left] && left < right);
        }
        if (sum >= 0) {
          //java always uses latest value from memory
          //move all the way to left if the number is the same
          while (nums[right--] == nums[right] && left < right);
        }
      }
      while (nums[i] == nums[++i] && i < nums.length - 2);
    }
    return result;
  }
}
