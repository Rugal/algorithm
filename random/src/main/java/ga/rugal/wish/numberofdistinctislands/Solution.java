package ga.rugal.wish.numberofdistinctislands;

import java.util.HashSet;
import java.util.Set;

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

  private int[][] grid;

  private boolean[][] visited;

  private StringBuilder pattern;

  private Set<String> patterns;

  private int[] start;

  public int numberofDistinctIslands(final int[][] grid) {
    this.grid = grid;
    this.visited = new boolean[grid.length][grid[0].length];
    this.patterns = new HashSet<>();

    for (int i = 0; i < grid.length; ++i) {
      for (int j = 0; j < grid[0].length; ++j) {
        if (this.visitable(i, j)) {
          this.pattern = new StringBuilder();
          this.start = new int[]{i, j};
          dfs(i, j);
          this.patterns.add(this.pattern.toString());
        }
      }
    }

    return this.patterns.size();
  }

  private boolean visitable(final int row, final int column) {
    return 0 <= row && row < this.grid.length
           && 0 <= column && column < this.grid[0].length
           && this.grid[row][column] == 1
           && !this.visited[row][column];
  }

  private void dfs(final int row, final int column) {
    this.visited[row][column] = true;
    this.pattern.append(row - this.start[0]).append(column - this.start[1]);

    for (int i = 0; i < X.length; ++i) {
      final int[] N = X[i];
      final int r = row + N[0];
      final int c = column + N[1];
      if (this.visitable(r, c)) {
        this.dfs(r, c);
      }
    }
  }
}
