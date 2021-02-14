package ga.rugal.amazon.besttimetobuyandsellstock;

public class Solution {
  public int maxProfit(final int[] prices) {
    if (null == prices || 2 > prices.length)
      return 0;
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    for (int i : prices) {
      // update the minimum found till this point
      min = Math.min(min, i);
      // calculate profit based on minimum found yet
      max = Math.max(max, i - min);
    }
    return max;
  }
}
