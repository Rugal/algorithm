package ga.rugal.amazon.question2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// CLASS BEGINS, THIS CLASS IS REQUIRED

public class Solution {

  private int result = -1;

  // These arrays are used to get row and column numbers
  // of 8 neighbors of a given cell
  private static final int ROW_NEIBOUGH[] = new int[]{-1, 0, 0, 1};

  private static final int COL_NEIBOUGH[] = new int[]{0, -1, 1, 0};

  // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
  private boolean isSafe(List<List<Integer>> lot, int row, int col, boolean visited[][]) {
    // row number is in range, column number is in range
    // and value is 1 and not yet visited
    return (row >= 0) && (row < visited.length)
           && (col >= 0) && (col < visited[0].length)
           && lot.get(row).get(col) != 0
           && !visited[row][col];
  }

  // A utility function to do DFS for a 2D boolean matrix.
  // It only considers the 8 neighbors as adjacent vertices
  private void dfs(List<List<Integer>> lot, int row, int col, boolean visited[][], int count) {

    // Mark this cell as visited
    visited[row][col] = true;

    // Recur for all connected neighbours
    for (int i = 0; i < 4; ++i) {
      if (this.isSafe(lot, row + ROW_NEIBOUGH[i], col + COL_NEIBOUGH[i], visited)) {
        ++count;
        final Integer get = lot.get(row + ROW_NEIBOUGH[i]).get(col + COL_NEIBOUGH[i]);
        if (get == 1) {
          dfs(lot, row + ROW_NEIBOUGH[i], col + COL_NEIBOUGH[i], visited, count);
        }
        if (get == 9) {
          if (this.result != -1) {
            this.result = Math.min(this.result, count);
          } else {
            result = count;
          }
          return;
        }
      }
    }
  }

  public int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot) {
    // WRITE YOUR CODE HERE
    //find obstacle coordinates    this.result = 0;
    final boolean[][] visited = new boolean[numRows][numColumns];
    this.dfs(lot, 0, 0, visited, 0);
    return this.result;
  }
  // METHOD SIGNATURE ENDS

  public static void main(String[] args) {
    final Solution s = new Solution();
    List<List<Integer>> lot = new ArrayList<>();
    lot.add(Arrays.asList(1, 0, 0));
    lot.add(Arrays.asList(1, 0, 0));
    lot.add(Arrays.asList(1, 9, 1));
    s.removeObstacle(3, 3, lot);
  }
}
