package ga.rugal.leetcode.containerwithmostwater;

/**
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public int maxArea(int[] height) {

    int max = 0;
    for (int left = 0, right = height.length - 1; left < right;) {
      max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }
    }

    return max;
  }
}
