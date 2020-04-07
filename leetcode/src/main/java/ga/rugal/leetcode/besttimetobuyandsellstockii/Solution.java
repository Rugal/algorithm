/*
 * Copyright 2020 rugal.
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
package ga.rugal.leetcode.besttimetobuyandsellstockii;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * @author rugal
 */
public class Solution {

  public int maxProfit(int[] prices) {
    if (prices.length < 2) {
      return 0;
    }

    int maxProfit = 0;
    for (int i = 1; i < prices.length; i++) {
      int diff = prices[i] - prices[i - 1];
      if (diff > 0) {
        maxProfit += diff;
      }
    }

    return maxProfit;
  }
}
