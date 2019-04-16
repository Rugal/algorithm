package ga.rugal.leetcode.trappingrainwater;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public int trap(final int[] height) {
    if (height.length == 0) {
      return 0;
    }
    final int[][] maxHeight = new int[2][height.length];

    //max height from left
    maxHeight[0] = new int[height.length];
    maxHeight[0][0] = height[0];
    for (int i = 1; i < height.length; ++i) {
      maxHeight[0][i] = Integer.max(maxHeight[0][i - 1], height[i]);
    }

    //max height from right side
    maxHeight[1] = new int[height.length];
    maxHeight[1][height.length - 1] = height[height.length - 1];
    for (int i = height.length - 2; i >= 0; --i) {
      maxHeight[1][i] = Integer.max(maxHeight[1][i + 1], height[i]);
    }

    //traverse array to get minimum column, and subtract the underlying height
    int sum = 0;
    for (int i = 0; i < height.length; ++i) {
      sum += Integer.min(maxHeight[0][i], maxHeight[1][i]) - height[i];
    }
    return sum;
  }
}
