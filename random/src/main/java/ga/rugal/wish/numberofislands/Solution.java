package ga.rugal.wish.numberofislands;

/**
 * https://leetcode.com/problems/number-of-islands/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  private static final int[][] X = new int[][]{
    {0, 1},
    {1, 0},
    {0, -1},
    {-1, 0}
  };

  private char[][] grid;

  private boolean[][] visited;

  public int numIslands(final char[][] grid) {
    this.grid = grid;
    this.visited = new boolean[grid.length][grid[0].length];

    int count = 0;

    for (int i = 0; i < grid.length; ++i) {
      for (int j = 0; j < grid[0].length; ++j) {
        if (this.visitable(i, j)) {
          dfs(i, j);
          ++count;
        }
      }
    }

    return count;
  }

  private boolean visitable(final int row, final int column) {
    return 0 <= row && row < this.grid.length
           && 0 <= column && column < this.grid[0].length
           && this.grid[row][column] == '1'
           && !this.visited[row][column];
  }

  private void dfs(final int row, final int column) {
    this.visited[row][column] = true;
    for (int[] N : X) {
      final int r = row + N[0];
      final int c = column + N[1];
      if (this.visitable(r, c)) {
        this.dfs(r, c);
      }
    }
  }
}
