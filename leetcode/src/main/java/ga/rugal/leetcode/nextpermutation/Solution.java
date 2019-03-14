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
package ga.rugal.leetcode.nextpermutation;

/**
 * https://leetcode.com/problems/next-permutation/
 *
 * @author rugal
 */
public class Solution {

  public void nextPermutation(int[] nums) {
    int i = nums.length - 2;
    //find i that [i] < [i+1]
    while (i >= 0 && nums[i + 1] <= nums[i]) {
      i--;
    }
    if (i >= 0) {
      int j = nums.length - 1;
      //find first j from tail that [j] > [i]
      while (j >= 0 && nums[j] <= nums[i]) {
        j--;
      }
      swap(nums, i, j);
      //so now [i] <-> [j]
      //from head, it is one digit larger than before
    }
    reverse(nums, i + 1);
  }

  private void reverse(int[] nums, int start) {
    int i = start, j = nums.length - 1;
    while (i < j) {
      swap(nums, i, j);
      i++;
      j--;
    }
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
