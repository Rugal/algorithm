package ga.rugal.leetcode.findwinneronatictactoegame;

/**
 * https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/
 *
 * @author rugal
 */
public class Solution {

  public String tictactoe(final int[][] moves) {
    if (moves.length < 5) {
      return "Pending";
    }

    final String[][] grid = new String[3][3];
    // construct grid
    for (int i = 0; i < moves.length; i++) {
      grid[moves[i][0]][moves[i][1]] = (i % 2 == 0) ? "A" : "B";
    }

    // check each row
    // since it is TTT game, if grid[0][i] is null, impossible to start from here
    for (int i = 0; i < 3; i++) {
      if (grid[0][i] != null
          && grid[0][i] == grid[1][i] // it is either null or reference to "A/B"
          && grid[0][i] == grid[2][i]) { // simply compare pointer
        return grid[0][i];
      }
    }

    // check each column
    for (int i = 0; i < 3; i++) {
      if (grid[i][0] != null && grid[i][0] == grid[i][1] && grid[i][0] == grid[i][2]) {
        return grid[i][0];
      }
    }

    // check left diagonal
    if (grid[0][0] != null && grid[0][0] == grid[1][1] && grid[0][0] == grid[2][2]) {
      return grid[0][0];
    }

    // check right diagonal
    if (grid[0][2] != null && grid[0][2] == grid[1][1] && grid[0][2] == grid[2][0]) {
      return grid[0][2];
    }

    return moves.length == 9 ? "Draw" : "Pending";
  }
}
