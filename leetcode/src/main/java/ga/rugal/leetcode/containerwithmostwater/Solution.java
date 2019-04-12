package ga.rugal.leetcode.containerwithmostwater;

/**
 * https://leetcode.com/problems/container-with-most-water/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  /**
   * |       |
   * |   |   |  |
   * |   |   |  |  |<BR>
   *
   * Because in this question, water is penetrative.<BR>
   * We only need to care about the area of water that are covered by columns.<BR>
   *
   * @param height
   * @return
   */
  public int maxArea(int[] height) {

    int max = 0;
    for (int left = 0, right = height.length - 1; left < right;) {
      //length * min(height)
      max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
      //now we are about to move closer, as length is shortened, we should look for higher column
      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }
    }

    return max;
  }
}
