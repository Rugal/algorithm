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
package ga.rugal.leetcode.maximumsubarray;

/**
 * https://leetcode.com/problems/maximum-subarray/
 *
 * @author rugal
 */
public class Solution {

  public int maxSubArray(int[] nums) {
    int acc = 0, max = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      acc = Math.max(acc, 0); // reset negative accumulation as the new value can at least be positive
      acc += nums[i];//try to accumulate
      max = Math.max(max, acc);//
    }

    return max;

  }
}
