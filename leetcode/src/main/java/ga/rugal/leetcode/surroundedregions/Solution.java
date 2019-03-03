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
package ga.rugal.leetcode.surroundedregions;

/**
 * https://leetcode.com/problems/surrounded-regions/
 *
 * @author rugalbernstein
 */
public class Solution {

  private static final int[] X = new int[]{0, 1, 0, -1};

  private static final int[] Y = new int[]{1, 0, -1, 0};

  private char[][] board;

  public void solve(final char[][] b) {
    this.board = b;

    if (null == b || b.length == 0) {
      return;
    }

    for (int i = 0; i < this.board.length; ++i) {
      flip(i, 0, 'O', 'R');
      flip(i, this.board[0].length - 1, 'O', 'R');
    }
    for (int i = 0; i < this.board[0].length; ++i) {
      flip(0, i, 'O', 'R');
      flip(this.board.length - 1, i, 'O', 'R');
    }

    for (int i = 0; i < this.board.length; ++i) {
      for (int j = 0; j < this.board[0].length; ++j) {
        flip(i, j, 'O', 'X');
      }
    }
    for (int i = 0; i < this.board.length; ++i) {
      for (int j = 0; j < this.board[0].length; ++j) {
        flip(i, j, 'R', 'O');
      }
    }
  }

  private void flip(final int row, final int column, final char from, final char to) {
    if (row < 0 || row >= this.board.length
        || column < 0 || column >= this.board[0].length
        || this.board[row][column] != from) {
      return;
    }
    this.board[row][column] = to;

    for (int i = 0; i < X.length; ++i) {
      flip(row + X[i], column + Y[i], from, to);
    }
  }
}
