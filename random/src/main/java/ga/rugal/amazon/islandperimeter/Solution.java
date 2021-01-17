package ga.rugal.amazon.islandperimeter;

/**
 * https://leetcode.com/problems/island-perimeter
 *
 * @author rugal
 */
public class Solution {

  public int islandPerimeter(final int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    int total = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] != 1) {
          continue;
        }
        // add 4 for each cell
        total += 4;
        // deduct side for top
        if (i > 0 && grid[i - 1][j] == 1) {
          // 1 for each side, so 2 in total
          total -= 2;
        }
        // deduct side for left
        if (j > 0 && grid[i][j - 1] == 1) {
          // 1 for each side, so 2 in total
          total -= 2;
        }
      }
    }
    return total;
  }
}
