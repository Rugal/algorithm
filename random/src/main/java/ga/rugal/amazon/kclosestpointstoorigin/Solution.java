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
package ga.rugal.amazon.kclosestpointstoorigin;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 *
 * @author rugal
 */
public class Solution {

  public int[][] kClosest(int[][] points, int K) {
    final PriorityQueue<int[]> pq = new PriorityQueue<>((b, a) -> -(b[0] * b[0] + b[1] * b[1]) + (a[0] * a[0] + a[1] * a[1]));

    for (int[] d : points) {
      pq.offer(d);
      if (pq.size() > K) {
        pq.poll();
      }
    }

    return pq.stream().toArray(int[][]::new);
  }
}
