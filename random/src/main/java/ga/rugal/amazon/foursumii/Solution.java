package ga.rugal.amazon.foursumii;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/4sum-ii
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    final var map = new HashMap<Integer, Integer>();
    // convert n^4 into n^2
    for (int a : A) {
      for (int d : D) {
        // cache pair of combination into map
        map.put(a + d, map.getOrDefault(a + d, 0) + 1);
      }
    }

    int res = 0;
    for (int b : B) {
      for (int c : C) {
        // same as 2 sum, try to get from cache
        res += map.getOrDefault(-(b + c), 0);
      }
    }
    return res;
  }
}
