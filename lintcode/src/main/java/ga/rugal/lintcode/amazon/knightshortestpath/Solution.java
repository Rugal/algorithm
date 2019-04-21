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
package ga.rugal.lintcode.amazon.knightshortestpath;

import java.util.LinkedList;
import java.util.Queue;

import ga.rugal.lintcode.Point;

/**
 * https://www.lintcode.com/problem/knight-shortest-path/description
 *
 * @author rugal
 */
public class Solution {

  private static final int[][] N = new int[][]{{1, 2, 2, 1, -1, -2, -2, -1},
                                               {2, 1, -1, -2, -2, -1, 1, 2}};

  private boolean[][] grid;

  /**
   * @param grid:        a chessboard included 0 (false) and 1 (true)
   * @param source:      a point
   * @param destination: a point
   *
   * @return the shortest path
   */
  public int shortestPath(final boolean[][] grid, final Point source, final Point destination) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return -1;
    }
    if (source.x == destination.x && source.y == destination.y) {
      return 0;
    }
    this.grid = grid;
    final Queue<Point> q = new LinkedList<>();
    final boolean[][] visited = new boolean[grid.length][grid[0].length];
    q.offer(source);

    int dist = 0;

    while (!q.isEmpty()) {
      dist++;
      int size = q.size();
      for (int i = 0; i < size; i++) {
        final Point cur = q.poll();
        for (int k = 0; k < N[0].length; k++) {
          int nx = cur.x + N[0][k];
          int ny = cur.y + N[1][k];
          if (this.isValid(nx, ny) && !visited[nx][ny]) {
            if (nx == destination.x && ny == destination.y) {
              return dist;
            }
            q.offer(new Point(nx, ny));
            visited[nx][ny] = true;
          }
        }
      }
    }

    return -1;
  }

  private boolean isValid(final int x, final int y) {
    return 0 <= x && x < this.grid.length
           && 0 <= y && y < this.grid[0].length
           && !this.grid[x][y];
  }
}
