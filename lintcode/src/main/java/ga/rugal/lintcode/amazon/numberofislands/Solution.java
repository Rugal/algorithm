package ga.rugal.lintcode.amazon.numberofislands;

/**
 * https://www.lintcode.com/problem/number-of-islands/description
 *
 * @author Rugal Bernstein
 */
public class Solution {

  private static final int[] X = new int[]{0, 1, 0, -1};

  private static final int[] Y = new int[]{1, 0, -1, 0};

  /**
   * @param grid: a boolean 2D matrix
   *
   * @return an integer
   */
  public int numIslands(final boolean[][] grid) {
    if (grid.length == 0) {
      return 0;
    }
    int counter = 0;
    final boolean[][] visit = new boolean[grid.length][grid[0].length];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (this.canVisit(grid, visit, i, j)) {
          this.dfs(grid, visit, i, j);
          counter++;
        }
      }
    }
    return counter;
  }

  private boolean canVisit(final boolean[][] grid, final boolean[][] visit,
                           final int row, final int column) {
    return row >= 0 && row < grid.length
           && column >= 0 && column < grid[0].length
           && grid[row][column]
           && !visit[row][column];
  }

  private void dfs(final boolean[][] grid, final boolean[][] visit,
                   final int row, final int column) {
    visit[row][column] = true;

    for (int i = 0; i < X.length; ++i) {
      if (this.canVisit(grid, visit, row + X[i], column + Y[i])) {
        this.dfs(grid, visit, row + X[i], column + Y[i]);
      }
    }
  }
}
