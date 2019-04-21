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
package ga.rugal.leetcode.matrixcellsindistanceorder;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/contest/weekly-contest-133/problems/matrix-cells-in-distance-order/
 *
 * @author rugal
 */
public class Solution {

  private static final int[] X = new int[]{0, 1, 0, -1, 1, 1, -1, -1, 2, 0, -2, 0};

  private static final int[] Y = new int[]{1, 0, -1, 0, 1, -1, 1, -1, 0, 2, 0, -2};

  private int R;

  private int C;

  public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
    this.R = R;
    this.C = C;
    final Queue<Point> q = new LinkedList<>();
    final boolean[][] visited = new boolean[R][C];
    final int[][] result = new int[R * C][2];
    int count = 0;
    q.offer(new Point(r0, c0));
    visited[r0][c0] = true;
    while (!q.isEmpty()) {
      final Point top = q.poll();
      result[count][0] = top.x;
      result[count++][1] = top.y;
      for (int i = 0; i < X.length; ++i) {
        final int x = top.x + X[i];
        final int y = top.y + Y[i];
        if (this.isValid(x, y) && !visited[x][y]) {
          q.offer(new Point(x, y));
          visited[x][y] = true;
        }
      }
    }
    return result;
  }

  private boolean isValid(final int x, final int y) {
    return 0 <= x && x < this.R && 0 <= y && y < this.C;
  }

  private class Point {

    int x;

    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
