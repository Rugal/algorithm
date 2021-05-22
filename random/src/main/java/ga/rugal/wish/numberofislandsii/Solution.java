package ga.rugal.wish.numberofislandsii;

import java.util.ArrayList;
import java.util.List;

import ga.rugal.wish.Point;

/**
 * https://www.lintcode.com/problem/434/
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

  private boolean[][] board;

  private UnionFindSet set;

  private int count = 0;

  /**
   * @param n:         An integer
   * @param m:         An integer
   * @param operators: an array of point
   *
   * @return an integer array
   */
  public List<Integer> numIslands2(int n, int m, Point[] operators) {
    final List<Integer> result = new ArrayList<>();
    if (null == operators) {
      return result;
    }
    this.board = new boolean[n][m];
    this.set = new UnionFindSet(n, m);
    for (Point p : operators) {
      this.dfs(p);
      result.add(this.count);
    }
    return result;
  }

  private boolean visitable(final int row, final int column) {
    return 0 <= row && row < this.board.length
           && 0 <= column && column < this.board[0].length;
  }

  private void dfs(final Point p) {
    if (this.board[p.x][p.y]) {
      return;
    }
    this.board[p.x][p.y] = true;
    ++this.count;
    for (int[] N : X) {
      int x = p.x + N[0];
      int y = p.y + N[1];

      if (!this.visitable(x, y) || !this.board[x][y]) {
        continue;
      }

      final Point root = this.set.find(p);
      final Point newRoot = this.set.find(new Point(x, y));
      if (this.set.union(root, newRoot)) {
        --this.count;
      }
    }
  }

  private static class UnionFindSet {

    private final int[][] rank;

    private final Point[][] parent;

    public UnionFindSet(final int n, final int m) {
      this.rank = new int[n + 1][m + 1];
      this.parent = new Point[n + 1][m + 1];
      for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
          this.parent[i][j] = new Point(i, j);
        }
      }
    }

    private boolean same(Point a, Point b) {
      return a.x == b.x && a.y == b.y;
    }

    /**
     * Find the representative of element.
     *
     * @param i
     *
     * @return
     */
    public Point find(final Point p) {
      if (!this.same(p, this.parent[p.x][p.y])) {
        this.parent[p.x][p.y] = this.find(this.parent[p.x][p.y]);
      }
      return this.parent[p.x][p.y];
    }

    /**
     * Union 2 element into one set by rank and path compression.
     *
     * @param left
     * @param right
     *
     * @return false if the 2 elements are already in one set, otherwise return true
     */
    public boolean union(final Point left, final Point right) {
      final Point x = this.find(left);
      final Point y = this.find(right);
      if (x == y) {
        //no merge need
        return false;
      }
      if (this.rank[y.x][y.y] > this.rank[x.x][x.y]) {
        this.parent[x.x][x.y] = y;
        return true;
      }
      if (this.rank[y.x][y.y] < this.rank[x.x][x.y]) {
        this.parent[y.x][y.y] = x;
        return true;
      }
      this.parent[y.x][y.y] = x;
      ++this.rank[x.x][x.y];
      return true;
    }
  }
}
