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
package ga.rugal.leetcode.longestincreasingsubsequence;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 *
 * @author rugal
 */
public class Solution {

  public int lengthOfLIS(final int[] nums) {
    if (nums.length < 2) {
      return nums.length;
    }
    int[] length = new int[nums.length];
    //each element start from 1 as base
    for (int i = 0; i < nums.length; length[i++] = 1);
    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        //each time compare
        if (nums[j] < nums[i] && length[j] + 1 > length[i]) {
          length[i] = length[j] + 1;
        }
      }
    }
    int max = 0;
    for (int i = 0; i < length.length; i++) {
      if (max < length[i]) {
        max = length[i];
      }
    }
    return max;
  }
}
