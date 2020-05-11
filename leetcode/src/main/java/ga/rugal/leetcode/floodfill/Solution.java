package ga.rugal.leetcode.floodfill;

/**
 * https://leetcode.com/problems/flood-fill/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  private static final int[] X = new int[]{0, 1, 0, -1};

  private static final int[] Y = new int[]{1, 0, -1, 0};

  private int[][] image;

  private boolean[][] visited;

  private int originColor;

  private int newColor;

  private boolean visitable(final int row, final int column) {
    return row >= 0 && row < this.image.length
           && column >= 0 && column < this.image[0].length
           && this.image[row][column] == this.originColor
           && !this.visited[row][column];
  }

  private void dfs(final int row, final int column) {
    this.image[row][column] = this.newColor;
    this.visited[row][column] = true;
    for (int i = 0; i < X.length; ++i) {
      final int r = row + X[i];
      final int c = column + Y[i];
      if (this.visitable(r, c)) {
        this.dfs(r, c);
      }
    }
  }

  public int[][] floodFill(final int[][] image, final int sr, final int sc, final int newColor) {
    this.image = image;
    this.originColor = image[sr][sc];
    this.newColor = newColor;
    this.visited = new boolean[image.length][image[0].length];
    this.dfs(sr, sc);
    return image;
  }
}
