package ga.rugal.leetcode.knightprobabilityinchessboard;

/**
 * https://leetcode.com/problems/knight-probability-in-chessboard/
 *
 * @author Rugal
 */
public class Solution {

  private static final int[] X = new int[]{2, 2, -2, -2, 1, 1, -1, -1};

  private static final int[] Y = new int[]{1, -1, 1, -1, 2, -2, 2, -2};

  private double[][][] memoization;

  private boolean isLive(final int r, final int c) {
    return 0 <= r && r < this.memoization.length && 0 <= c && c < this.memoization.length;
  }

  private double dp(final int k, final int r, final int c) {
    if (!this.isLive(r, c)) {
      return 0;
    }
    if (-1 != this.memoization[r][c][k]) {
      return this.memoization[r][c][k];
    }
    if (k == 0) {
      this.memoization[r][c][k] = 1;
      return 1;
    }

    double sum = 0;
    for (int i = 0; i < X.length; ++i) {
      sum += this.dp(k - 1, r + X[i], c + Y[i]);
    }
    this.memoization[r][c][k] = sum / 8.0;
    return this.memoization[r][c][k];
  }

  public double knightProbability(final int N, final int K, final int r, final int c) {
    this.memoization = new double[N][N][K + 1];
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < N; ++j) {
        for (int s = 0; s <= K; ++s) {
          this.memoization[i][j][s] = -1;
        }
      }
    }
    return this.dp(K, r, c);
  }
}
