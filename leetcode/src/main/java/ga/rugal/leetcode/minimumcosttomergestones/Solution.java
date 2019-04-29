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
package ga.rugal.leetcode.minimumcosttomergestones;

/**
 * https://leetcode.com/problems/minimum-cost-to-merge-stones/
 * https://www.youtube.com/watch?v=FabkoUzs64o
 *
 * @author rugal
 */
public class Solution {

  int[][][] dp;

  int N;

  public int mergeStones(int[] stones, int K) {
    N = stones.length;
    if (N == 1) {
      return 0;
    }
    if ((N - 1) % (K - 1) != 0) {
      return -1;
    }

    dp = new int[N][N][K + 1];
    return next(stones, 0, stones.length - 1, K, 1);
  }

  // calculate sum of stones from [i, j]
  private int sum(int[] stones, int i, int j) {
    int sum = 0;
    while (i <= j) {
      sum += stones[i++];
    }
    return sum;
  }

  private int next(int[] stones, int start, int stop, int K, int p) {
    // only one stone
    if (start == stop) {
      return 0;
    }

    // we've already done with this situation
    if (dp[start][stop][p] != 0) {
      return dp[start][stop][p];
    }

    // some stones to form one pile, if K stones just return sum, otherwise divide them to K piles
    if (p == 1) {
      dp[start][stop][p] = sum(stones, start, stop);
      if (stop - start >= K) {
        dp[start][stop][p] += next(stones, start, stop, K, K);
      }
      return dp[start][stop][p];
    }

    // first pile has (j - i) / (K - 1) situations
    int min = Integer.MAX_VALUE;
    for (int a = start; a < stop; a += K - 1) {
      int tmp = next(stones, start, a, K, 1) + next(stones, a + 1, stop, K, p - 1);
      if (tmp < min) {
        min = tmp;
      }
    }
    // save the result of this situation
    dp[start][stop][p] = min;
    return dp[start][stop][p];
  }
}
