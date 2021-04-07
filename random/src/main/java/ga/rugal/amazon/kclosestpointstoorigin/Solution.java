package ga.rugal.amazon.kclosestpointstoorigin;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 *
 * @author rugal
 */
public class Solution {

  public int[][] kClosest(int[][] points, int K) {
    return this.kClosest_quickSelect(points, K);
  }

  public int[][] kClosest_sort(int[][] points, int K) {
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

  public int[][] kClosest_quickSelect(int[][] points, int k) {
    if (points == null || points.length == 0 || k <= 0) {
      return new int[0][0];
    }
    if (points.length <= k) {
      return points;
    }

    quickSelect(points, k, 0, points.length - 1);
    return Arrays.copyOfRange(points, 0, k);
  }

  private void quickSelect(int[][] points, int k, int left, int right) {
    if (left == right) {
      return;
    }
    final int i = left;
    final int j = right;
    int pivot = left + ((right - left) / 2);
    int pivotD = distance(points[pivot]);
    while (left <= right) {
      int leftD = distance(points[left]);
      int rightD = distance(points[right]);
      if (leftD < pivotD) {
        left++;
      } else if (rightD > pivotD) {
        right--;
      } else {
        this.swap(points, left, right);
        left++;
        right--;
      }
    }

    if (left < k) {
      this.quickSelect(points, k, left, j);
    } else if (left > k) {
      this.quickSelect(points, k, i, left - 1);
    }
  }

  private int distance(int[] point) {
    return point[0] * point[0] + point[1] * point[1];
  }

  private void swap(int[][] points, int i, int j) {
    int[] tmp = points[i];
    points[i] = points[j];
    points[j] = tmp;
  }
}
