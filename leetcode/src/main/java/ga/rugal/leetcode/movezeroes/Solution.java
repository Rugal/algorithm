/*
 * Copyright 2020 rugal.
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
package ga.rugal.leetcode.movezeroes;

/**
 *
 * @author rugal
 */
public class Solution {

  public void moveZeroes(int[] nums) {
    for (int nonZero = 0, current = 0; current < nums.length; current++) {
      if (nums[current] != 0) {
        final int temp = nums[nonZero];
        nums[nonZero++] = nums[current];
        nums[current] = temp;
      }
    }
  }
}
