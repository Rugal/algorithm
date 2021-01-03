package ga.rugal.leetcode.capacitytoshippackageswithinddays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
 *
 * @author rugal
 */
public class Solution {

  private int minimumDay(final int[] weights, final int capacity) {
    int day = 1;
    int current = 0;
    for (int w : weights) {
      if (current + w > capacity) {
        ++day;
        current = 0;
      }
      current += w;
    }
    return day;
  }

  public int shipWithinDays(final int[] weights, final int day) {
    int left = Arrays.stream(weights).max().getAsInt();
    int right = Arrays.stream(weights).sum();
    int value = 0;
    while (left <= right) {
      final int mid = (left + right) / 2;
      if (this.minimumDay(weights, mid) <= day) {
        // now this capacity is big enough, we want to minimize it
        right = mid - 1;
        value = mid;
      } else {
        // more capacity is required
        left = mid + 1;
      }
    }
    return value;
  }
}
