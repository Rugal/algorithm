package ga.rugal.leetcode.trappingrainwater;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public int trap(int[] height) {
    if (height.length == 0) {
      return 0;
    }
    //max height from left
    int[] left = new int[height.length];
    left[0] = height[0];
    for (int i = 1; i < height.length; ++i) {
      left[i] = Math.max(left[i - 1], height[i]);
    }

    //max height from right side
    int[] right = new int[height.length];
    right[height.length - 1] = height[height.length - 1];
    for (int i = height.length - 2; i >= 0; --i) {
      right[i] = Math.max(right[i + 1], height[i]);
    }

    int sum = 0;
    for (int i = 0; i < height.length; ++i) {
      sum += Math.min(left[i], right[i]) - height[i];
    }

    return sum;
  }
}
