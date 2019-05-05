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

  /**
   * To find next permutation, the easiest way is:<BR>
   * 1. Find first decreasing number x from backward order<BR>
   * 2. Start from there, find the first number that is "just" bigger than x<BR>
   * 3. Swap them<BR>
   * 4. Reverse numbers after x
   *
   * @param nums
   */
  public void nextPermutation(final int[] nums) {
    int x = nums.length - 2;
    //start from end of array, find the first number i that is decreasing
    while (x >= 0 && nums[x + 1] <= nums[x]) {
      x--;
    }
    //it is not the largest number
    if (x >= 0) {
      int i = nums.length - 1;
      //from the very right, find first j that [i] > [x]
      for (; i >= 0 && nums[i] <= nums[x]; --i);
      this.swap(nums, x, i);
      //so now [i] <-> [j]
      //from head, it is one digit larger than before
    }
    this.reverse(nums, x + 1);
  }

  private void reverse(final int[] nums, final int start) {
    int i = start, j = nums.length - 1;
    while (i < j) {
      this.swap(nums, i, j);
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
