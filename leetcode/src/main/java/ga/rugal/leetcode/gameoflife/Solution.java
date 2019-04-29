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
package ga.rugal.leetcode.gameoflife;

/**
 * https://leetcode.com/problems/game-of-life/
 *
 * @author rugal
 */
public class Solution {

  private static int[] xs = new int[]{1, -1, 0, 0, 1, 1, -1, -1};

  private static int[] ys = new int[]{0, 0, 1, -1, 1, -1, 1, -1};

  /**
   * Any live cell with {@code < 2} live neighbors dies, as if caused by under-population.<BR>
   * Any live cell with [2, 3] live neighbors lives on to the next generation.<BR>
   * Any live cell with {@code > 3} live neighbors dies, as if by over-population..<BR>
   * Any dead cell with = 3 live neighbors becomes a live cell, as if by reproduction.<BR>
   *
   *
   * @param board
   */
  public void gameOfLife(int[][] board) {
    int[][] counts = count(board);

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {

        if (board[i][j] != 1) {
          if (counts[i][j] == 3) {
            board[i][j] = 1;
          }
        } else {
          if (counts[i][j] < 2) {
            // underpopulation
            board[i][j] = 0;
            continue;
          }
          if (counts[i][j] > 3) {
            // overpopulation
            board[i][j] = 0;
          }
        }
      }
    }
  }

  private int[][] count(int[][] board) {
    int[][] shadow = new int[board.length][];
    for (int i = 0; i < board.length; i++) {
      shadow[i] = new int[board[i].length];
      for (int j = 0; j < board[i].length; j++) {
        shadow[i][j] = countNeighbors(board, i, j);
      }
    }
    return shadow;
  }

  private int countNeighbors(int[][] board, int i, int j) {
    int count = 0;
    for (int k = 0; k < xs.length; k++) {
      int nx = xs[k] + i;
      int ny = ys[k] + j;
      if (nx >= 0 && ny >= 0 && nx < board.length && ny < board[i].length) {
        if (board[nx][ny] == 1) {
          count += 1;
        }
      }
    }
    return count;
  }
}
