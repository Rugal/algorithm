package ga.rugal.amazon.shortestunsortedcontinuoussubarray;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public int findUnsortedSubarray(final int[] nums) {
    return this.findUnsortedSubarray_traverse(nums);
  }

  public int findUnsortedSubarray_sort(final int[] nums) {
    final int[] copy = Arrays.copyOf(nums, nums.length);
    Arrays.sort(nums);
    int left = 0;
    for (int i = 0; i < nums.length; ++i) {
      if (nums[i] != copy[i]) {
        left = i;
        break;
      }
    }

    int right = -1;
    for (int i = nums.length - 1; i >= 0; --i) {
      if (nums[i] != copy[i]) {
        right = i;
        break;
      }
    }

    return right - left + 1;
  }

  public int findUnsortedSubarray_traverse(int[] nums) {
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    boolean flag = false;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i - 1] > nums[i]) {
        // whenever we see a decending slope
        flag = true;
      }
      if (flag) {
        min = Math.min(min, nums[i]);
      }
    }
    flag = false;
    for (int i = nums.length - 2; i >= 0; i--) {
      if (nums[i] > nums[i + 1]) {
        flag = true;
      }
      if (flag) {
        max = Math.max(max, nums[i]);
      }
    }
    int l, r;
    for (l = 0; l < nums.length; l++) {
      if (min < nums[l]) {
        break;
      }
    }
    for (r = nums.length - 1; r >= 0; r--) {
      if (max > nums[r]) {
        break;
      }
    }
    return r - l < 0 ? 0 : r - l + 1;
  }
}
