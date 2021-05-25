package ga.rugal.wish.minimumabsolutedifference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-absolute-difference/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public List<List<Integer>> minimumAbsDifference(final int[] array) {
    Arrays.sort(array);
    int min = Integer.MAX_VALUE;
    for (int i = 1; i < array.length; ++i) {
      min = Math.min(min, array[i] - array[i - 1]);
    }

    final List<List<Integer>> result = new ArrayList<>();
    for (int i = 1; i < array.length; ++i) {
      if (array[i] - array[i - 1] == min) {
        result.add(List.of(array[i - 1], array[i]));
      }
    }

    return result;
  }
}
