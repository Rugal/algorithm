/*
 * Copyright 2019 rugal.
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
package ga.rugal.leetcode.availablecapturesforrook;

/**
 * https://leetcode.com/problems/available-captures-for-rook/
 *
 * @author rugal
 */
public class Solution {

  private static final int LENGTH = 8;

  private static final int[][] NEIGHBOUR = new int[][]{{1, 0},
                                                       {0, 1},
                                                       {-1, 0},
                                                       {0, -1}};

  private char[][] board;

  public int numRookCaptures(final char[][] board) {
    this.board = board;
    int x = 0, y = 0;
    boolean found = false;
    for (x = 0; x < LENGTH; ++x) {
      for (y = 0; y < LENGTH; ++y) {
        if (board[x][y] == 'R') {
          found = true;
          break;
        }
      }
      if (found) {
        break;
      }
    }
    int result = 0;
    for (int i = 0; i < NEIGHBOUR.length; ++i) {
      result += this.count(x, y, NEIGHBOUR[i]);
    }
    return result;
  }

  private int count(int x, int y, final int[] direction) {
    for (int i = 0; i < LENGTH; ++i) {
      x += direction[0];
      y += direction[1];
      if (!this.isValid(x) || !this.isValid(y) || this.board[x][y] == 'B') {
        break;
      }
      if (this.board[x][y] == '.') {
        continue;
      }
      if (this.board[x][y] == 'p') {
        return 1;
      }
    }
    return 0;
  }

  private boolean isValid(final int x) {
    return 0 <= x && x < LENGTH;
  }
}
