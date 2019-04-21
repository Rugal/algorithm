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
package ga.rugal.leetcode.twocityscheduling;

import java.util.Arrays;

/**
 * https://leetcode.com/contest/weekly-contest-133/problems/two-city-scheduling/
 *
 * @author rugal
 */
public class Solution {

  public int twoCitySchedCost(int[][] costs) {
    int base = 0;
    int n = costs.length;
    int[] cs = new int[n];
    int p = 0;
    for (int[] c : costs) {
      //go to A by default
      base += c[0];
      cs[p++] = c[1] - c[0];
    }
    Arrays.sort(cs);
    for (int i = 0; i < n / 2; i++) {
      //then go to B by the different
      base += cs[i];
    }
    return base;
  }
}
