package ga.rugal.leetcode.threesumclosest;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum-closest/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  /**
   * Similar to the original question, but to go through all possible combination.<BR>
   * See what's the closest summation to target.
   *
   * @param nums
   * @param target
   *
   * @return
   */
  public int threeSumClosest(final int[] nums, final int target) {
    Arrays.sort(nums);
    int sum = 0;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length - 2;) {
      for (int left = i + 1, right = nums.length - 1; left < right;) {
        int temp = nums[i] + nums[left] + nums[right];
        final int diff = temp - target;
        if (Math.abs(diff) < min) {
          min = Math.abs(diff);
          sum = temp;
        }
        if (diff == 0) {
          break;
        }
        if (diff <= 0) {
          while (nums[left] == nums[++left] && left < right);
        }
        if (diff >= 0) {
          //java always uses new value from memory
          while (nums[right--] == nums[right] && left < right);
        }
      }
      while (nums[i] == nums[++i] && i < nums.length - 2);
    }
    return sum;
  }
}
