package ga.rugal.amazon.nestedlistweightsumii;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * https://www.lintcode.com/problem/551/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  /**
   * @param nestedList: a list of NestedInteger
   *
   * @return the sum
   */
  public int depthSumInverse(final List<NestedInteger> nestedList) {
    final Queue<NestedInteger> queue = new ArrayDeque<>(nestedList);

    int result = 0;
    int previousSum = 0;

    while (!queue.isEmpty()) {

      int current = 0;
      final int size = queue.size();

      for (int i = 0; i < size; ++i) {
        final NestedInteger poll = queue.poll();
        if (poll.isInteger()) {
          current += poll.getInteger();
        } else {
          queue.addAll(poll.getList());
        }
      }
      // add current number so this would contain all the current values
      previousSum += current;
      // keep adding previousSum to resut so there will be n times added to it for root level
      result += previousSum;
    }

    return result;
  }
}

/**
 * This is the interface that allows for creating nested lists. You should not implement it, or
 * speculate about its implementation
 */
interface NestedInteger {

  /**
   * @return true if this NestedInteger holds a single integer, rather than a nested list.
   */
  public boolean isInteger();

  /**
   * @return the single integer that this NestedInteger holds, if it holds a single integer Return
   *         null if this NestedInteger holds a nested list
   */
  public Integer getInteger();

  /**
   * @return the nested list that this NestedInteger holds, if it holds a nested list Return null if
   *         this NestedInteger holds a single integer
   */
  public List<NestedInteger> getList();
}
