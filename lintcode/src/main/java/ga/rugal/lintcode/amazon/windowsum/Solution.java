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
package ga.rugal.lintcode.amazon.windowsum;

/**
 * https://www.lintcode.com/problem/window-sum/description
 *
 * @author rugal
 */
public class Solution {

  /**
   * @param nums: a list of integers.
   * @param k:    length of window.
   *
   * @return the sum of the element inside the window at each moving.
   */
  public int[] winSum(final int[] nums, final int k) {
    if (null == nums || k == 0 || nums.length < k) {
      return new int[0];
    }
    final int[] sum = new int[nums.length - k + 1];
    //summation for the very first result
    for (int i = 0; i < k; ++i) {
      sum[0] += nums[i];
    }
    //then we slide the window
    for (int i = 1; i < sum.length; ++i) {
      sum[i] = sum[i - 1] + nums[i + k - 1] - nums[i - 1];
    }
    return sum;
  }
}
