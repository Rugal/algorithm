package ga.rugal.amazon.nestedlistweightsum;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://www.lintcode.com/problem/551/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public int depthSum_recursive(final List<NestedInteger> nestedList) {
    return this.test(nestedList, 1);
  }

  private int test(final List<NestedInteger> nestedList, final int level) {
    return nestedList.stream()
      .map(ni -> ni.isInteger()
                 ? ni.getInteger() * level
                 : this.test(ni.getList(), level + 1))
      .reduce(0, Integer::sum);
  }

  public int depthSum_iterative(List<NestedInteger> nestedList) {
    // Write your code here
    if (nestedList == null || nestedList.isEmpty()) {
      return 0;
    }
    int sum = 0;
    Queue<NestedInteger> queue = new LinkedList<>();
    for (NestedInteger nestedInt : nestedList) {
      queue.offer(nestedInt);
    }

    int depth = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      depth++;
      for (int i = 0; i < size; i++) {
        NestedInteger nestedInt = queue.poll();
        if (nestedInt.isInteger()) {
          sum += nestedInt.getInteger() * depth;
        } else {
          for (NestedInteger innerInt : nestedInt.getList()) {
            queue.offer(innerInt);
          }
        }
      }
    }
    return sum;
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
