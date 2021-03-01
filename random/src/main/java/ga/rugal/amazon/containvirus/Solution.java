package ga.rugal.amazon.containvirus;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/contain-virus/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  private static final int[][] X = new int[][]{
    {-1, 1, 0, 0},
    {0, 0, -1, 1}
  };

  private Set<Integer> seen;

  private List<Set<Integer>> regions;

  private List<Set<Integer>> frontiers;

  private List<Integer> perimeters;

  private int[][] grid;

  private int R, C;

  public int containVirus(final int[][] grid) {
    this.grid = grid;
    this.R = grid.length;
    this.C = grid[0].length;

    int ans = 0;
    while (true) {
      this.seen = new HashSet<>();
      this.regions = new ArrayList<>();
      this.frontiers = new ArrayList<>();
      this.perimeters = new ArrayList<>();

      // find each virus region
      // this is similar to "island" problem
      for (int r = 0; r < R; ++r) {
        for (int c = 0; c < C; ++c) {
          if (this.grid[r][c] == 1 && !this.seen.contains(r * this.C + c)) {
            this.regions.add(new HashSet<>());
            this.frontiers.add(new HashSet<>());
            this.perimeters.add(0);
            this.dfs(r, c);
          }
        }
      }

      // exit if there is no more virus region
      if (this.regions.isEmpty()) {
        break;
      }
      // find the virus region that has the largest frontier
      int triageIndex = 0;
      for (int i = 0; i < this.frontiers.size(); ++i) {
        if (this.frontiers.get(triageIndex).size() < this.frontiers.get(i).size()) {
          triageIndex = i;
        }
      }
      // so so this round we will block this specific virus region
      ans += this.perimeters.get(triageIndex);

      for (int i = 0; i < this.regions.size(); ++i) {
        if (i == triageIndex) {
          // eliminate target virus region
          for (int code : this.regions.get(i)) {
            this.grid[code / this.C][code % this.C] = -1;
          }
        } else {
          // the others will spread
          for (int code : this.regions.get(i)) {
            int r = code / C, c = code % C;
            for (int k = 0; k < 4; ++k) {
              int nr = r + X[0][k], nc = c + X[1][k];
              if (nr >= 0 && nr < R && nc >= 0 && nc < C && this.grid[nr][nc] == 0) {
                this.grid[nr][nc] = 1;
              }
            }
          }
        }
      }
    }
    return ans;
  }

  private boolean isValid(final int r, final int c) {
    return 0 <= r && r < R
           && 0 <= c && c < C;
  }

  private void dfs(final int r, final int c) {
    if (this.seen.contains(r * C + c)) {
      return;
    }
    this.seen.add(r * C + c);
    // the very last element is the current one
    final int N = this.regions.size();
    this.regions.get(N - 1).add(r * C + c);
    for (int k = 0; k < 4; ++k) {
      final int nr = r + X[0][k];
      final int nc = c + X[1][k];
      if (!this.isValid(nr, nc)) {
        continue;
      }
      if (this.grid[nr][nc] == 1) {
        this.dfs(nr, nc);
        continue;
      }
      if (this.grid[nr][nc] == 0) {
        this.frontiers.get(N - 1).add(nr * C + nc);
        this.perimeters.set(N - 1, this.perimeters.get(N - 1) + 1);
      }
    }
  }
}
