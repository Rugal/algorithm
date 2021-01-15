package ga.rugal.amazon.wordsearch;

/**
 * https://leetcode.com/problems/word-search/
 *
 * @author rugal
 */
public class Solution {

  private char[][] board;

  private String word;

  private static final int[] X = new int[]{0, 1, 0, -1};

  private static final int[] Y = new int[]{1, 0, -1, 0};

  public boolean exist(final char[][] board, final String word) {
    this.board = board;
    this.word = word;
    for (int i = 0; i < this.board.length; ++i) {
      for (int j = 0; j < this.board[0].length; ++j) {
        if (this.dfs(i, j, 0, new boolean[this.board.length][this.board[0].length])) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean isValid(final int row, final int column, final boolean[][] visit) {
    return 0 <= row && row < this.board.length
           && 0 <= column && column < this.board[0].length
           && !visit[row][column];
  }

  private boolean dfs(final int row, final int column, final int index, final boolean[][] visited) {
    if (this.word.charAt(index) != this.board[row][column]) {
      return false;
    }
    if (index == this.word.length() - 1) {
      return true;
    }
    visited[row][column] = true;
    for (int i = 0; i < X.length; ++i) {
      if (this.isValid(row + X[i], column + Y[i], visited)
          && this.dfs(row + X[i], column + Y[i], index + 1, visited)) {
        return true;
      }
    }

    return visited[row][column] = false;
  }
}
