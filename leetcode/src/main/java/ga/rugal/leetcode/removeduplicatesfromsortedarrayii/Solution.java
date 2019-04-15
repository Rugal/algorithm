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
package ga.rugal.leetcode.removeduplicatesfromsortedarrayii;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 *
 * @author rugal
 */
public class Solution {

  /**
   * Up to 2 times of duplication.
   *
   * @param nums
   *
   * @return
   */
  public int removeDuplicates(final int[] nums) {
    boolean first = true;
    int length = 0;
    for (int i = 0; i < nums.length; ++i) {
      if (i == 0
          || nums[i] != nums[length - 1]) {//if nums[i] is different from the last added number
        first = true;
        nums[length++] = nums[i];
        continue;
      }
      //have seen this number, but will add it again
      if (first) {
        first = false;
        nums[length++] = nums[i];
      }
    }

    return length;
  }
}
