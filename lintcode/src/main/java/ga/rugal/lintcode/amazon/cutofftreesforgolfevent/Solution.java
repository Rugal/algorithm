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
package ga.rugal.lintcode.amazon.cutofftreesforgolfevent;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://www.lintcode.com/problem/cut-off-trees-for-golf-event
 *
 * @author rugalbernstein
 */
public class Solution {

  private static final int[][] N = new int[][]{{1, 0, -1, 0},
                                               {0, 1, 0, -1}};

  private int[][] forest;

  /**
   * @param forest: a list of integers
   *
   * @return return a integer
   */
  public int cutOffTree(final List<List<Integer>> forest) {
    this.forest = new int[forest.size()][forest.get(0).size()];
    final PriorityQueue<Point> pq = new PriorityQueue<>();
    for (int i = 0; i < forest.size(); ++i) {
      final List<Integer> get = forest.get(i);
      for (int j = 0; j < get.size(); ++j) {
        this.forest[i][j] = get.get(j);
        if (get.get(j) > 1) {
          pq.offer(new Point(i, j, get.get(j)));
        }
      }
    }
    int cost = 0;
    Point start = new Point(0, 0, 0);
    while (!pq.isEmpty()) {
      final Point poll = pq.poll();
      final int value = this.bfs(start, poll);
      if (value == -1) {
        return -1;
      }
      cost += value;
      start = poll;
    }

    return cost;
  }

  private int bfs(final Point start, final Point stop) {
    final boolean[][] visited = new boolean[forest.length][forest[0].length];
    final Queue<Point> pq = new LinkedList<>();
    start.distance = 0;
    pq.offer(start);
    while (!pq.isEmpty()) {
      final Point top = pq.poll();
      if (top.equals(stop)) {
        this.forest[top.x][top.y] = 1;
        return top.distance;
      }
      for (int i = 0; i < N[0].length; ++i) {
        final int x = N[0][i] + top.x;
        final int y = N[1][i] + top.y;
        if (this.isValid(x, y)
            && !visited[x][y]
            && this.forest[x][y] > 0) {
          pq.offer(new Point(x, y, this.forest[x][y], top.distance + 1));
          visited[x][y] = true;
        }
      }
    }

    return -1;
  }

  private boolean isValid(final int x, final int y) {
    return 0 <= x && x < this.forest.length
           && 0 <= y && y < this.forest[0].length;
  }

  private class Point implements Comparable<Point> {

    int x;

    int y;

    int height;

    int distance = 0;

    public Point(int x, int y, int height) {
      this.x = x;
      this.y = y;
      this.height = height;
    }

    public Point(int x, int y, int height, int distance) {
      this(x, y, height);
      this.distance = distance;
    }

    @Override
    public int compareTo(Point o) {
      return this.height - o.height;
    }

    @Override
    public int hashCode() {
      int hash = 5;
      return hash;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (obj == null) {
        return false;
      }
      if (getClass() != obj.getClass()) {
        return false;
      }
      final Point other = (Point) obj;
      return this.x == other.x && this.y == other.y;
    }
  }
}
