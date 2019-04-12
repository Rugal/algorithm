/*
 * Copyright 2019 rugal.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ga.rugal.leetcode.coinchange;

/**
 * https://leetcode.com/problems/coin-change/
 *
 * @author rugal
 */
public class Solution {

  public int coinChange(final int[] coins, final int V) {
    // table[i] will be storing the minimum number of coins
    // required for i value.  So table[V] will have result
    final int[] result = new int[V + 1];

    // Base case (If given value V is 0)
    result[0] = 0;

    // Initialize all table values as Infinite
    for (int i = 1; i <= V; i++) {
      result[i] = Integer.MAX_VALUE;
    }
    // Compute minimum coins required for all
    // values from 1 to V
    for (int i = 1; i <= V; i++) {
      // Go through all coins smaller than i
      for (int j = 0; j < coins.length; j++) {
        //if this value is changable
        if (coins[j] > i) {
          continue;
        }
        final int value = result[i - coins[j]];//Get result of subproblem
        //The subproblem will be ignored if it is bigger than current choice
        //or it is not initialized
        if (value != Integer.MAX_VALUE && value + 1 < result[i]) {
          //only update under the condition that current choice is guarantee to be better
          result[i] = value + 1;
        }
      }
    }
    return result[V] == Integer.MAX_VALUE ? -1 : result[V];
  }
}
