package ga.rugal.amazon.triangle;

import java.util.List;

/**
 * https://leetcode.com/problems/triangle
 *
 * @author rugal
 */
public class Solution {

  public int minimumTotal(final List<List<Integer>> triangle) {
    final int[] result = new int[triangle.size() + 1];
    for (int i = triangle.size() - 1; i >= 0; --i) {
      final var get = triangle.get(i);
      for (int j = 0; j < get.size(); ++j) {
        result[j] = get.get(j) + Math.min(result[j], result[j + 1]);
      }
    }
    return result[0];
  }
}
