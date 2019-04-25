package ga.rugal.lintcode.amazon.slidingwindowmaximum;

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

  /**
   * @param nums: A list of integers.
   * @param k:    An integer
   *
   * @return The maximum number inside the window at each moving.
   */
  public List<Integer> maxSlidingWindow(int[] nums, int k) {
    final List<Integer> list = new ArrayList<>();
    if (k > nums.length) {
      return list;
    }
    final PriorityQueue<Pair> pairs = new PriorityQueue<>();
    for (int i = 0; i < nums.length; ++i) {
      //put value into max heap so the top will always be the maximum
      pairs.add(new Pair(nums[i], i));
      /*
       * but since this is sliding window, need to pop the outdated element we consider that [index
       * <= i - k] is outdated e.g. i = 5, k = 3 Sliding window is [3, 4, 5] so index 2 is outdated
       */
      while (i >= k && pairs.peek().index <= i - k) {
        pairs.poll();
      }

      //keep adding peek data once we have enough data in sliding window
      if (i >= k - 1) {
        list.add(pairs.peek().data);
      }
    }

    return list;
  }
}
