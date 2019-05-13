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
package ga.rugal.amazon.prisoncellsafterndays;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/prison-cells-after-n-days/
 *
 * @author rugal
 */
public class Solution {

  public int[] prisonAfterNDays(final int[] cells, int N) {
    final Map<Integer, Integer> seen = new HashMap<>();

    // state  = integer representing state of prison
    int state = 0;
    for (int i = 0; i < 8; ++i) {
      if (cells[i] > 0) {
        state ^= 1 << i;
      }
    }

    // While days remaining, simulate a day
    while (N > 0) {
      // If this is a cycle, fast forward by
      // seen.get(state) - N, the period of the cycle.
      if (seen.containsKey(state)) {
        N %= seen.get(state) - N;
      }
      seen.put(state, N);

      if (N >= 1) {
        N--;
        state = this.nextDay(state);
      }
    }

    // Convert the state back to the required answer.
    int[] ans = new int[8];
    for (int i = 0; i < 8; ++i) {
      if (((state >> i) & 1) > 0) {
        ans[i] = 1;
      }
    }

    return ans;
  }

  public int nextDay(final int state) {
    int ans = 0;

    // We only loop from 1 to 6 because 0 and 7 are impossible,
    // as those cells only have one neighbor.
    for (int i = 1; i <= 6; ++i) {
      if (((state >> (i - 1)) & 1) == ((state >> (i + 1)) & 1)) {
        ans ^= 1 << i;
      }
    }

    return ans;
  }
}
