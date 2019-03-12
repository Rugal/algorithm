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
package ga.rugal.leetcode.perfectsquares;

/**
 * https://leetcode.com/problems/perfect-squares/
 * https://leetcode.com/problems/perfect-squares/discuss/71488/Summary-of-4-different-solutions-(BFS-DP-static-DP-and-mathematics)
 *
 * @author rugal
 */
public class Solution {

  public int numSquares(int n) {
    //just like coin change
    //this is to initialize all coins available
    final int[] square = new int[n + 1];
    for (int i = 1; i * i <= n; ++i) {
      square[i] = i * i;
      if (n == square[i]) {
        return 1;
      }
    }

    final int[] dp = new int[n + 1];
    dp[0] = 0;
    for (int i = 1; i < dp.length; i++) {
      dp[i] = Integer.MAX_VALUE;
      for (int j = 0; j < square.length; j++) {
        if (i - square[j] >= 0 // if this amount is valid
            && dp[i - square[j]] != Integer.MAX_VALUE //if subproblem is solved
            && dp[i] > dp[i - square[j]] + 1) { //if this solution is better

          dp[i] = dp[i - square[j]] + 1;
        }
      }
    }

    return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
  }
}
