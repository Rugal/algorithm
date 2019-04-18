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
package ga.rugal.lintcode.amazon.kclosestpoints;

import java.util.PriorityQueue;

import ga.rugal.lintcode.Point;

/**
 * https://www.lintcode.com/problem/k-closest-points/description
 *
 * @author rugal
 */
public class Solution {

  /**
   * @param points: a list of points
   * @param origin: a point
   * @param k:      An integer
   *
   * @return the k closest points
   */
  public Point[] kClosest(final Point[] points, final Point origin, final int k) {
    // write your code here
    final Point[] result = new Point[k];
    final PriorityQueue<Pair> pq = new PriorityQueue<>(k, (a, b) -> b.distance != a.distance
                                                                    ? b.distance - a.distance
                                                                    : a.point.x != b.point.x
                                                                      ? b.point.x - a.point.x
                                                                      : b.point.y - a.point.y);
    for (Point p : points) {
      pq.offer(new Pair(p, origin));
      if (pq.size() > k) {
        pq.poll();
      }
    }
    for (int i = k - 1; i >= 0; --i) {
      result[i] = pq.poll().point;
    }
    return result;
  }

  class Pair {

    Point point;

    int distance;

    public Pair(final Point point, final Point origin) {
      this.point = point;
      int dx = this.point.x - origin.x;
      int dy = this.point.y - origin.y;
      this.distance = dx * dx + dy * dy;
    }
  }
}
