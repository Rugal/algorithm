package ga.rugal.amazon.kclosestpointstoorigin;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 *
 * @author rugal
 */
public class Solution {

  public int[][] kClosest(int[][] points, int K) {
    final PriorityQueue<int[]> pq = new PriorityQueue<>((b, a) -> (a[0] * a[0] + a[1] * a[1])
                                                                  - (b[0] * b[0] + b[1] * b[1]));
    for (int[] d : points) {
      pq.offer(d);
      if (pq.size() > K) {
        pq.poll();
      }
    }

    return pq.stream().toArray(int[][]::new);
  }
}
