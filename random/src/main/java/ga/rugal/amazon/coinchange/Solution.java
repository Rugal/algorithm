package ga.rugal.amazon.coinchange;

/**
 * https://leetcode.com/problems/coin-change/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public int coinChange(final int[] coins, final int amount) {
    final int[] table = new int[amount + 1];
    for (int i = 0; i <= amount; ++i) {
      table[i] = Integer.MAX_VALUE;
    }
    table[0] = 0;

    for (int i = 1; i <= amount; ++i) {
      for (var c : coins) {
        if (c <= i
            && table[i - c] != Integer.MAX_VALUE
            && table[i - c] + 1 < table[i]) {
          table[i] = table[i - c] + 1;
        }
      }
    }

    return table[amount] == Integer.MAX_VALUE ? -1 : table[amount];
  }
}
