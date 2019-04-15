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

  /**
   * just like coin change.
   *
   * @param n
   *
   * @return
   */
  public int numSquares(int n) {
    //this is to initialize all coins available
    final int[] square = new int[n + 1];
    for (int i = 0; i <= n; ++i) {
      square[i] = i * i;
      if (square[i] == n) {
        return 1;
      }
    }
    final int[] result = new int[n + 1];
    for (int i = 1; i < result.length; ++i) {
      result[i] = Integer.MAX_VALUE;
      // if this amount is valid
      for (int j = 0; i >= square[j] && j < square.length; ++j) {
        final int value = result[i - square[j]];
        if (value != Integer.MAX_VALUE//if subproblem is solved
            && value + 1 < result[i]) {//if this solution is better
          result[i] = value + 1;
        }
      }
    }
    return result[n];
  }
}
