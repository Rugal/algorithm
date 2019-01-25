package ga.rugal.leetcode.mincostclimbingstairs;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public int minCostClimbingStairs(int[] cost) {

    int first = cost[0];
    int second = cost[1];
    for (int i = 2; i < cost.length; ++i) {
      int temp = cost[i] + Math.min(first, second);
      first = second;
      second = temp;
    }

    return Math.min(first, second);
  }
}
