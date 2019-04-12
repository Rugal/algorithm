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
package ga.rugal.leetcode.firstmissingpositive;

/**
 * https://leetcode.com/problems/first-missing-positive/
 *
 * @author rugalbernstein
 */
public class Solution {

  private int[] numbers;

  public int firstMissingPositive(int[] nums) {
    this.numbers = nums;
    for (int i = 0; i < nums.length; ++i) {
      //put number to the correct index. n into index n - 1, begin with 1
      while (nums[i] > 0 && nums[i] <= nums.length //if index for move is valid
             && nums[nums[i] - 1] != nums[i]) {//if value for move is different
        //keep swapping till everything in this round fits in their own place
        this.swap(i, nums[i] - 1);
      }
    }
    //now that these number should be under correct index
    //whichever not match must be the first positive number
    for (int i = 0; i < nums.length; ++i) {
      if (nums[i] != i + 1) {
        return i + 1;
      }
    }
    //or everything match, then the first missing positive is the biggest number
    return nums.length + 1;
  }

  private void swap(final int from, final int to) {
    final int temp = this.numbers[from];
    this.numbers[from] = this.numbers[to];
    this.numbers[to] = temp;
  }
}
