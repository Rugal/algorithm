package ga.rugal.amazon.designtictactoe;

/**
 * https://leetcode.com/problems/design-tic-tac-toe/
 *
 * @author rugalbernstein
 */
public class TicTacToe {

  private final boolean[][] board;

  private final int[] rows;

  private final int[] cols;

  private int diagonal;

  private int antiDiagonal;

  private int count = 0;

  private int xTurn = 1;

  private boolean gameEnd = false;

  /**
   * Initialize your data structure here.
   *
   * @param n
   */
  public TicTacToe(final int n) {
    this.rows = new int[n];
    this.cols = new int[n];
    this.board = new boolean[n][n];
  }

  public TicTacToe() {
    this(3);
  }

  /**
   * Player {player} makes a move at ({row}, {col}).
   *
   * @param row    The row of the board.
   * @param col    The column of the board.
   * @param player The player, can be either 1 or 2.
   *
   * @return The current winning condition, can be either: 0: No one wins. 1: Player 1 wins. 2:
   *         Player 2 wins.
   */
  public int move(final int row, final int col, final int player) {
    int toAdd = player == 1 ? 1 : -1;
    ++this.count;

    this.board[row][col] = true;

    this.rows[row] += toAdd;
    this.cols[col] += toAdd;
    if (row == col) {
      this.diagonal += toAdd;
    }

    if (col == (this.cols.length - row - 1)) {
      this.antiDiagonal += toAdd;
    }

    final int size = this.rows.length;
    if (Math.abs(this.rows[row]) == size
        || Math.abs(this.cols[col]) == size
        || Math.abs(this.diagonal) == size
        || Math.abs(this.antiDiagonal) == size) {
      return player;
    }

    return 0;
  }

  public boolean move(final int row, final int col) throws AlreadyTakenException, GameEndException {
    if (this.gameEnd) {
      throw new GameEndException();
    }
    if (this.board[row][col]) {
      throw new AlreadyTakenException();
    }
    final int result = this.move(row, col, this.xTurn);
    if (0 != result) {
      this.gameEnd = true;
      return true;
    }
    if (this.count >= 9) {
      System.out.println("it's a draw");
    }
    this.xTurn *= -1;
    return false;
  }
}

class AlreadyTakenException extends Exception {

}

class GameEndException extends Exception {

}
