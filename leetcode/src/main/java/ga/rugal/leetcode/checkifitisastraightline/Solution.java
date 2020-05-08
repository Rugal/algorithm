package ga.rugal.leetcode.checkifitisastraightline;

/**
 * https://leetcode.com/problems/check-if-it-is-a-straight-line/
 *
 * @author rugal
 */
public class Solution {

  private double getSlope(final int[] a, final int[] b) {
    return (a[1] - b[1]) * 1.0 / (a[0] - b[0]);
  }

  public boolean checkStraightLine(final int[][] coordinates) {
    final double slope = this.getSlope(coordinates[0], coordinates[1]);
    for (int i = 1; i < coordinates.length; ++i) {
      if (this.getSlope(coordinates[i], coordinates[i - 1]) != slope) {
        return false;
      }
    }
    return true;
  }
}
