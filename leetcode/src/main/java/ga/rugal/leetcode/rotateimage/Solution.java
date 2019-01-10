package ga.rugal.leetcode.rotateimage;

/**
 * https://leetcode.com/problems/rotate-image/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public void rotate(int[][] matrix) {
    if (matrix.length <= 1) {
      return;
    }
    for (int i = 0; i < matrix.length / 2; ++i) {
      this.swapRight(matrix, matrix.length - 2 * i, i);
      this.swapDown(matrix, matrix.length - 2 * i, i);
      this.swapLeft(matrix, matrix.length - 2 * i, i);
    }
  }

  public void swapRight(final int[][] matrix, int length, int row) {
    for (int i = 0; i < length - 1; ++i) {
      int temp = matrix[row][i + row];
      matrix[row][i + row] = matrix[row + i][length - 1 + row];
      matrix[row + i][length - 1 + row] = temp;
    }
  }

  public void swapDown(final int[][] matrix, int length, int row) {
    for (int i = 0; i < length - 1; ++i) {
      int temp = matrix[row][i + row];
      matrix[row][i + row] = matrix[matrix.length - row - 1][matrix.length - i - 1 - row];
      matrix[matrix.length - row - 1][matrix.length - i - 1 - row] = temp;
    }
  }

  public void swapLeft(final int[][] matrix, int length, int row) {
    for (int i = 0; i < length - 1; ++i) {
      int temp = matrix[row][i + row];
      matrix[row][i + row] = matrix[matrix.length - 1 - i - row][row];
      matrix[matrix.length - 1 - i - row][row] = temp;
    }
  }
}
