package ga.rugal.leetcode.searcha2dmatrixii;

/**
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  private int[][] matrix;

  private int target;

  public boolean searchMatrix(final int[][] matrix, final int target) {
    if (matrix == null || matrix.length == 0) {
      return false;
    }

    this.matrix = matrix;
    this.target = target;

    return this.search(0, this.matrix.length - 1, 0, this.matrix[0].length - 1);
  }

  private boolean search(final int up, final int down, final int left, final int right) {
    if (left > right || up > down) {
      return false;
    } else if (this.matrix[up][left] > this.target || this.matrix[down][right] < this.target) {
      return false;
    }

    final int mid = (left + right) / 2;
    int row;
    for (row = up;
         row <= down && this.matrix[row][mid] <= this.target;
         ++row) {
      if (this.matrix[row][mid] == this.target) {
        return true;
      }
    }

    return this.search(row, down, left, mid) || this.search(up, row - 1, mid + 1, right);
  }
}
