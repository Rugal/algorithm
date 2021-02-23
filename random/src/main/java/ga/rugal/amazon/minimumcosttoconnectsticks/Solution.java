package ga.rugal.amazon.minimumcosttoconnectsticks;

import java.util.List;
import java.util.PriorityQueue;

/**
 * https://www.lintcode.com/problem/1872/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  /**
   * @param sticks: the length of sticks
   *
   * @return Minimum Cost to Connect Sticks
   */
  public int MinimumCost(final List<Integer> sticks) {
    // write your code here
    final PriorityQueue<Integer> queue = new PriorityQueue<>();
    for (int stick : sticks) {
      queue.add(stick);
    }
    int result = 0;
    while (queue.size() > 1) {
      final int value = queue.poll() + queue.poll();
      result += value;
      queue.offer(value);
    }
    return result;
  }
}
