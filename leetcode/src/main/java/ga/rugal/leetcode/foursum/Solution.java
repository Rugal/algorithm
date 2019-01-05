package ga.rugal.leetcode.foursum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public List<List<Integer>> fourSum(int[] nums, int target) {
    final List<List<Integer>> result = new ArrayList<>();
    if (null == nums || nums.length < 4) {
      return result;
    }
    Arrays.sort(nums);
    //select first number
    for (int first = 0; first < nums.length - 3;) {
      //select second number
      for (int second = first + 1; second < nums.length - 2;) {
        for (int left = second + 1, right = nums.length - 1; left < right;) {
          final int sum = nums[first] + nums[second] + nums[left] + nums[right];
          if (sum == target) {
            result.add(Arrays.asList(nums[first], nums[second], nums[left], nums[right]));
          }
          if (sum <= target) {
            while (nums[left] == nums[++left] && left < right);
          }
          if (sum >= target) {
            //java always uses new value from memory
            while (nums[right--] == nums[right] && left < right);
          }
        }
        while (nums[second] == nums[++second] && second < nums.length - 2);
      }
      while (nums[first] == nums[++first] && first < nums.length - 3);
    }
    //use two pointer to find possible numbers

    return result;
  }
}
