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
package ga.rugal.lintcode.amazon.numberofdistinctislandsii;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * https://www.lintcode.com/problem/number-of-distinct-islands-ii/
 *
 * @author rugalbernstein
 */
public class Solution {

  private final int[] dir = {-1, 0, 1, 0, -1};

  private final int[][] refl = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

  /**
   * @param grid: the 2D grid
   *
   * @return the number of distinct islands
   */
  public int numDistinctIslands2(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    Set<String> set = new HashSet<>();
    List<Point> list = new ArrayList<>();
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          bfs(grid, i, j, list);
        }
        if (list.size() > 0) {
          set.add(norm(list));
          list.clear();
        }
      }
    }
    return set.size();
  }

  private void bfs(int[][] grid, int row, int col, List<Point> list) {
    Queue<Point> queue = new ArrayDeque<>();
    Point start = new Point(row, col);
    queue.add(start);
    list.add(start);
    grid[row][col] = 2;
    while (!queue.isEmpty()) { //bfs队列判断
      Point p = queue.poll();
      for (int i = 0; i < 4; i++) {
        int r = p.x + dir[i], c = p.y + dir[i + 1];
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != 1) {
          continue;
        }
        grid[r][c] = 2;
        Point next = new Point(r, c);
        list.add(next);
        queue.add(next);
      }
    }
  }

  private String norm(List<Point> list) {
    List<Point>[] comb = new List[8];

    for (int i = 0; i < 4; i++) {
      comb[i] = new ArrayList<>();
      comb[i + 4] = new ArrayList<>();
      for (Point p : list) {
        comb[i].add(new Point(p.x * refl[i][0], p.y * refl[i][1]));
        comb[i + 4].add(new Point(p.y * refl[i][1], p.x * refl[i][0]));
      }
    }

    for (int i = 0; i < 8; i++) {
      Collections.sort(comb[i]);
    }
    String[] s = new String[8];
    for (int i = 0; i < 8; i++) {
      StringBuilder sb = new StringBuilder();
      int x0 = comb[i].get(0).x, y0 = comb[i].get(0).y;
      for (Point p : comb[i]) {
        sb.append(p.x - x0);
        sb.append(',');
        sb.append(p.y - y0);
        sb.append('!');
      }
      s[i] = sb.toString();
    }
    Arrays.sort(s);
    return s[0];
  }

  public static class Point implements Comparable<Point> {

    int x;

    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public int compareTo(Point p) {
      return this.x - p.x == 0 ? this.y - p.y : this.x - p.x;
    }
  }
}
