package ga.rugal.leetcode.kthlargestelementinanarray;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public int findKthLargest(int[] nums, int k) {
    final PriorityQueue<Integer> queue = new PriorityQueue<>(k);
    queue.add(nums[0]);
    for (int i = 1; i < nums.length; i++) {
      int num = nums[i];
      if (queue.size() < k) {
        queue.add(num);
        continue;
      }
      final int head = queue.peek();
      if (num >= head) {
        queue.poll();
        queue.add(num);
      }
    }
    return queue.poll();
  }
}
