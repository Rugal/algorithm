package ga.rugal.leetcode;

/**
 *
 * @author Rugal Bernstein
 * @see https://leetcode.com/problems/unique-paths-ii/description/
 */
public class UniquePath2 {

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    final int row = obstacleGrid.length;
    final int column = obstacleGrid[0].length;

    if (obstacleGrid[row - 1][column - 1] == 1) {
      return 0;
    }

    int[][] value = new int[row][column];
    value[row - 1][column - 1] = 1;
    for (int i = row - 2; i >= 0; i--) {
      if (0 == obstacleGrid[i][column - 1]) {
        value[i][column - 1] = value[i + 1][column - 1];
      }
    }

    for (int i = column - 2; i >= 0; i--) {
      if (0 == obstacleGrid[row - 1][i]) {
        value[row - 1][i] = value[row - 1][i + 1];
      }
    }

    for (int i = row - 2; i >= 0; i--) {
      for (int j = column - 2; j >= 0; j--) {
        if (obstacleGrid[i][j] == 1) {
          continue;
        }
        value[i][j] = value[i][j + 1] + value[i + 1][j];
      }
    }

    return value[0][0];
  }
}
