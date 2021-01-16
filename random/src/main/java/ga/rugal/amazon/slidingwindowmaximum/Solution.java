package ga.rugal.amazon.slidingwindowmaximum;

/**
 * https://leetcode.com/problems/sliding-window-maximum/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums.length * k == 0) {
      return new int[0];
    }
    if (k == 1) {
      return nums;
    }
    // build max table from left to right
    // meaning for each k block, the right most element is the max of this block
    final var left = new int[nums.length];
    left[0] = nums[0];
    // build max table from right to left
    // meaning for each k block, the left most element is the max of this block
    final var right = new int[nums.length];
    right[nums.length - 1] = nums[nums.length - 1];
    for (int i = 1; i < nums.length; i++) {
      // from left to right
      left[i] = i % k == 0
                // block_start set value to the start of each block
                ? nums[i]
                // for value between blocks, always set it as the max value within this block
                : Math.max(left[i - 1], nums[i]);

      // from right to left
      final int j = nums.length - i - 1;
      right[j] = (j + 1) % k == 0
                 // block_end set value to the start of each block
                 ? nums[j]
                 // for value between blocks, always set it as the max value within this block
                 : Math.max(right[j + 1], nums[j]);
    }

    var output = new int[nums.length - k + 1];
    for (int i = 0; i < nums.length - k + 1; i++) {
      output[i] = Math.max(left[i + k - 1], // the max value of this block from left to right
                           right[i]); // the max value of this block from right to left
    }

    return output;
  }
}
