package ga.rugal.leetcode.slidingwindowmaximum;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/sliding-window-maximum/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  static class Pair implements Comparable<Pair> {

    public int data;

    public int index;

    public Pair(int data, int index) {
      this.data = data;
      this.index = index;
    }

    @Override
    public int compareTo(Pair o) {
      return o.data - this.data;
    }
  }

  public int[] maxSlidingWindow(int[] nums, int k) {
    final List<Integer> list = new ArrayList<>();
    if (k > nums.length) {
      return list.stream().mapToInt(i -> i).toArray();
    }
    final PriorityQueue<Pair> pairs = new PriorityQueue<>();
    for (int i = 0; i < nums.length; ++i) {
      pairs.add(new Pair(nums[i], i));
      if (i >= k) {
        while (pairs.peek().index <= i - k) {
          pairs.poll();
        }
      }
      if (i >= k - 1) {
        list.add(pairs.peek().data);
      }
    }

    return list.stream().mapToInt(i -> i).toArray();
  }
}
