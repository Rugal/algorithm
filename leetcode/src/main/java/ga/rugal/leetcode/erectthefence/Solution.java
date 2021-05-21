package ga.rugal.leetcode.erectthefence;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

/**
 * https://leetcode.com/problems/erect-the-fence/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public int orientation(int[] p, int[] q, int[] r) {
    return (q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1]);
  }

  public int[][] outerTrees(final int[][] points) {
    Arrays.sort(points, (int[] p, int[] q) -> q[0] - p[0] == 0 ? q[1] - p[1] : q[0] - p[0]);
    final Stack<int[]> hull = new Stack<>();
    for (int[] point : points) {
      while (hull.size() >= 2 && orientation(hull.get(hull.size() - 2), hull.get(hull.size() - 1), point) > 0) {
        hull.pop();
      }
      hull.push(point);
    }
    hull.pop();
    for (int i = points.length - 1; i >= 0; i--) {
      while (hull.size() >= 2 && orientation(hull.get(hull.size() - 2), hull.get(hull.size() - 1), points[i]) > 0) {
        hull.pop();
      }
      hull.push(points[i]);
    }
    // remove redundant elements from the stack
    final HashSet<int[]> ret = new HashSet<>(hull);
    return ret.toArray(new int[ret.size()][]);
  }
}
