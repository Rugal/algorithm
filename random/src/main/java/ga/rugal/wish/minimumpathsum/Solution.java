package ga.rugal.wish.minimumpathsum;

/**
 * https://leetcode.com/problems/minimum-path-sum/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public int minPathSum(final int[][] board) {
    final int[] result = new int[board[0].length];

    result[0] = board[0][0];

    for (int i = 1; i < board[0].length; ++i) {
      result[i] = result[i - 1] + board[0][i];
    }

    for (int i = 1; i < board.length; ++i) {
      for (int j = 0; j < board[0].length; ++j) {
        int min = Integer.MAX_VALUE;
        if (j > 0 && result[j - 1] < min) {
          min = result[j - 1];
        }
        if (result[j] < min) {
          min = result[j];
        }

        result[j] = board[i][j] + min;
      }
    }
    return result[board[0].length - 1];
  }

  public int minimumPath_backup(final int[][] board) {

    final int ROW = board.length;

    final int COLUMN = board[0].length;

    final int[][] result = new int[ROW][COLUMN];

    result[ROW - 1][COLUMN - 1] = board[ROW - 1][COLUMN - 1];

    for (int i = ROW - 2; i >= 0; --i) {

      result[i][COLUMN - 1] = board[i][COLUMN - 1] + result[i + 1][COLUMN - 1];

    }

    for (int i = COLUMN - 2; i >= 0; --i) {

      result[ROW - 1][i] = board[ROW - 1][i] + result[ROW - 1][i + 1];

    }

    for (int i = ROW - 2; i >= 0; --i) {

      for (int j = COLUMN - 2; j >= 0; --j) {

        result[i][j] = board[i][j] + Math.min(result[i][j + 1], result[i + 1][j]);

      }

    }

    return result[0][0];

  }
}
