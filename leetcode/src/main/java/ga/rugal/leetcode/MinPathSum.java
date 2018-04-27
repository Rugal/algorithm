package ga.rugal.leetcode;

/**
 *
 * @author Rugal Bernstein
 */
public class MinPathSum {

  public int minPathSum(int[][] grid) {
    int row = grid.length, column = grid[0].length;
    final int[][] value = new int[row][column];
    value[row - 1][column - 1] = grid[row - 1][column - 1];

    for (int i = row - 2; i >= 0; i--) {
      value[i][column - 1] = grid[i][column - 1] + value[i + 1][column - 1];
    }

    for (int i = column - 2; i >= 0; i--) {
      value[row - 1][i] = grid[row - 1][i] + value[row - 1][i + 1];
    }

    for (int i = row - 2; i >= 0; i--) {
      for (int j = column - 2; j >= 0; j--) {
        value[i][j] = grid[i][j] + Math.min(value[i + 1][j], value[i][j + 1]);
      }
    }
    return value[0][0];
  }
}
