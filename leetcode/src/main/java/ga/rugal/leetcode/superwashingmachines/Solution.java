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
package ga.rugal.leetcode.superwashingmachines;

/**
 * https://leetcode.com/problems/super-washing-machines
 *
 * @author rugal
 */
public class Solution {

  public int findMinMoves(int[] machines) {
    int total = 0;
    for (int clothes : machines) {
      total += clothes;
    }

    if (total % machines.length != 0) {
      return -1;
    }

    /*
     * Example 1: [1, 1, 6, 6, 1], total dresses: 15, target dresses: 3, 
     * maximum offload is 3 (6 - 3).
     * Running balance:[-2][-4][ -1][ 2][ 0]
     * Answer: max(3, abs(-4)) = 4.
     *
     * Example 2: [1, 1, 4, 8, 1], total dresses: 15, target dresses: 3,
     * maximum offload is 5 (8 - 3).
     * Running balance:[-2][-4][ -3][ 2][ 0]
     * Answer: max(5, abs(-4)) = 5
     *
     */
    final int avg = total / machines.length;
    int maxRunningBalance = 0;//maximum number of accumulative requirement
    int maxOffLoad = 0;//maximum number of offload from a machine
    int runningBalance = 0;

    for (int clothes : machines) {
      final int offload = clothes - avg;
      runningBalance += offload;
      maxRunningBalance = Math.max(maxRunningBalance, Math.abs(runningBalance));
      maxOffLoad = Math.max(maxOffLoad, offload);
    }

    return Math.max(maxOffLoad, maxRunningBalance);
  }
}
