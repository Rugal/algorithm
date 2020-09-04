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
package ga.rugal.amazon.snakesandladders;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * https://leetcode.com/problems/snakes-and-ladders/
 *
 * @author rugalbernstein
 */
public class Solution {

  private int[][] board;

  public int snakesAndLadders(final int[][] board) {
    this.board = board;

    //both visited map and result cache
    //otherwise we have to have a SET to store the visited element
    //and use Pair object to store the known length
    final Map<Integer, Integer> result = new HashMap();
    result.put(1, 0);

    final Queue<Integer> queue = new LinkedList();
    queue.add(1);

    while (!queue.isEmpty()) {
      final int current = queue.remove();
      if (current == this.board.length * this.board.length) {
        return result.get(current);
      }

      for (int i = current + 1;
           i <= Math.min(current + 6, this.board.length * this.board.length);
           ++i) {
        final int rc = get(i);
        final int r = rc / this.board.length;
        final int c = rc % this.board.length;
        //if -1, just move, otherwise move to the end of ladder or snake
        final int next = board[r][c] == -1 ? i : board[r][c];
        //if never visited before
        if (!result.containsKey(next)) {
          //cache the result till now, the number of steps to position "next"
          result.put(next, result.get(current) + 1);
          queue.add(next);
        }
      }
    }
    return -1;
  }

  /**
   * Given a square num s, return board coordinates (r, c) as r*N + c
   *
   * @param square
   *
   * @return
   */
  public int get(final int square) {
    final int quot = (square - 1) / this.board.length;
    final int rem = (square - 1) % this.board.length;
    final int row = this.board.length - 1 - quot;
    final int col = row % 2 != this.board.length % 2
                    ? rem // if
                    : this.board.length - 1 - rem;
    return row * this.board.length + col;
  }
}
