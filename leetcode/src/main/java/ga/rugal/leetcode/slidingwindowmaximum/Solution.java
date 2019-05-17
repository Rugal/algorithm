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

  public int[] maxSlidingWindow(final int[] nums, final int k) {
    final List<Integer> list = new ArrayList<>();
    if (k > nums.length) {
      return list.stream().mapToInt(i -> i).toArray();
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

    return list.stream().mapToInt(i -> i).toArray();
  }

  public int[] maxSlidingWindow2(int[] nums, int k) {
    int n = nums.length;
    if (n * k == 0) {
      return new int[0];
    }
    if (k == 1) {
      return nums;
    }

    int[] left = new int[n];
    left[0] = nums[0];
    int[] right = new int[n];
    right[n - 1] = nums[n - 1];
    for (int i = 1; i < n; i++) {
      // from left to right
      if (i % k == 0) {
        left[i] = nums[i];  // block_start
      } else {
        left[i] = Math.max(left[i - 1], nums[i]);
      }

      // from right to left
      int j = n - i - 1;
      if ((j + 1) % k == 0) {
        right[j] = nums[j];  // block_end
      } else {
        right[j] = Math.max(right[j + 1], nums[j]);
      }
    }

    int[] output = new int[n - k + 1];
    for (int i = 0; i < n - k + 1; i++) {
      output[i] = Math.max(left[i + k - 1], right[i]);
    }

    return output;
  }

}
