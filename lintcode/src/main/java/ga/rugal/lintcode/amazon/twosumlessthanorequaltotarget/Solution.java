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
package ga.rugal.lintcode.amazon.twosumlessthanorequaltotarget;

/**
 * https://www.lintcode.com/problem/two-sum-less-than-or-equal-to-target/description
 *
 * @author rugal
 */
public class Solution {

  /**
   * @param nums:   an array of integer
   * @param target: an integer
   *
   * @return an integer
   */
  public int twoSum5(int[] nums, int target) {
    // write your code here
    int count = 0;
    for (int i = 0; i < nums.length; ++i) {
      for (int j = i + 1; j < nums.length; ++j) {
        if (nums[i] + nums[j] <= target) {
          ++count;
        }
      }
    }

    return count;
  }
}
