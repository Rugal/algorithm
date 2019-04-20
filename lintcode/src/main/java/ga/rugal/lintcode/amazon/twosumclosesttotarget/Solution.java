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
package ga.rugal.lintcode.amazon.twosumclosesttotarget;

import java.util.Arrays;

/**
 * https://www.lintcode.com/problem/two-sum-closest-to-target/description
 *
 * @author rugal
 */
public class Solution {

  /**
   * @param nums:   an integer array
   * @param target: An integer
   *
   * @return the difference between the sum and the target
   */
  public int twoSumClosest(final int[] nums, final int target) {
    Arrays.sort(nums);
    // write your code here
    int diff = Integer.MAX_VALUE;
    for (int left = 0, right = nums.length - 1; left < right;) {
      final int sum = nums[left] + nums[right];
      if (sum == target) {
        return 0;
      }
      if (sum < target) {
        ++left;
      } else {
        --right;
      }

      final int abs = Math.abs(sum - target);
      if (abs < diff) {
        diff = abs;
      }
    }
    return diff;
  }
}
