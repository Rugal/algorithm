package ga.rugal.amazon.findkclosestelements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/find-k-closest-elements/
 *
 * @author Rugal Bernstein
 */
public class Solution {
  public List<Integer> findClosestElements(final int[] data, final int number, final int target) {
    int current = Arrays.binarySearch(data, target);
    if (current < 0) {
      current = -current - 1;
    }

    int left = Math.max(0, current - number - 1);
    int right = Math.min(data.length - 1, current + number - 1);
    while (right - left + 1 > number) {
      final int l = Math.abs(target - data[left]);
      final int r = Math.abs(target - data[right]);
      if (l <= r) { // can't move to left or right is bigger
        --right;
      } else { // can't move to right or left is bigger
        ++left;
      }
    }

    return IntStream
      .rangeClosed(left, right)
      .mapToObj(i -> data[i])
      .collect(Collectors.toCollection(ArrayList::new));
  }
}
