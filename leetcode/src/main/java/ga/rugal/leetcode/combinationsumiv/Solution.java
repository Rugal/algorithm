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
package ga.rugal.leetcode.combinationsumiv;

/**
 * https://leetcode.com/problems/combination-sum-iv/
 *
 * @author rugal
 */
public class Solution {

  /**
   * Just like coin change question.
   *
   * @param nums
   * @param target
   * @return
   */
  public int combinationSum4(final int[] nums, final int target) {
    final int[] dp = new int[target + 1];
    dp[0] = 1;
    for (int i = 1; i <= target; i++) {
      for (int num : nums) {
        if (i >= num) {
          //add all possible combination so we don't have to filter the small ones
          dp[i] += dp[i - num];
        }
      }
    }
    return dp[target];
  }
}
