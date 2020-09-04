/*
 * Copyright 2019 rugalbernstein.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ga.rugal.amazon.designtictactoe;

/**
 * https://leetcode.com/problems/design-tic-tac-toe/
 *
 * @author rugalbernstein
 */
public class TicTacToe {

  private final int[] rows;

  private final int[] cols;

  private int diagonal;

  private int antiDiagonal;

  /**
   * Initialize your data structure here.
   *
   * @param n
   */
  public TicTacToe(final int n) {
    rows = new int[n];
    cols = new int[n];
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

    rows[row] += toAdd;
    cols[col] += toAdd;
    if (row == col) {
      diagonal += toAdd;
    }

    if (col == (cols.length - row - 1)) {
      antiDiagonal += toAdd;
    }

    final int size = rows.length;
    if (Math.abs(rows[row]) == size
        || Math.abs(cols[col]) == size
        || Math.abs(diagonal) == size
        || Math.abs(antiDiagonal) == size) {
      return player;
    }

    return 0;
  }
}
