package ga.rugal.leetcode.setmatrixzeroes;

/**
 * https://leetcode.com/problems/set-matrix-zeroes
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public void setZeroes(int[][] matrix) {
    if (matrix == null || (matrix.length <= 1 && matrix[0].length <= 1)) {
      return;
    }

    //Search matrix
    //Search first column
    boolean firstColumnZero = false;
    for (int row = 0; row < matrix.length; ++row) {
      if (matrix[row][0] == 0) {
        firstColumnZero = true;
        break;
      }
    }
    //Search first row
    boolean firstRowZero = false;
    for (int column = 0; column < matrix[0].length; ++column) {
      if (matrix[0][column] == 0) {
        firstRowZero = true;
        break;
      }
    }
    //Search other place
    for (int row = 1; row < matrix.length; ++row) {
      for (int column = 1; column < matrix[0].length; ++column) {
        if (matrix[row][column] == 0) {
          matrix[row][0] = matrix[0][column] = 0;
        }
      }
    }

    //Set matrix
    //by row
    for (int row = 1; row < matrix.length; ++row) {
      if (matrix[row][0] == 0) {
        for (int column = 1; column < matrix[0].length; ++column) {
          matrix[row][column] = 0;
        }
      }
    }
    //by column
    for (int column = 1; column < matrix[0].length; ++column) {
      if (matrix[0][column] == 0) {
        for (int row = 1; row < matrix.length; ++row) {
          matrix[row][column] = 0;
        }
      }
    }
    //Set first column
    if (firstColumnZero) {
      for (int row = 0; row < matrix.length; ++row) {
        matrix[row][0] = 0;
      }
    }
    //Set first row
    if (firstRowZero) {
      for (int column = 0; column < matrix[0].length; ++column) {
        matrix[0][column] = 0;
      }
    }
  }
}
