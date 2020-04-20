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
package ga.rugal.leetcode.searchinrotatedsortedarray;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 *
 * @author rugal
 */
public class Solution {

  public int search(int[] nums, int target) {
    for (int left = 0, right = nums.length; left < right;) {
      final int mid = (left + right) / 2;

      /*
       * [ ] [             ]
       * 8 9 0 1 2 3 4 5 6 7
       *         *
       *         mid
       * if mid and target is on the different side, set the mid number as MIN or MAX depending
       * on the side of mid
       */

      /*
       * [           ] [   ]
       * 3 4 5 6 7 8 9 0 1 2
       *         *
       *         mid
       */
      final int number = (nums[0] > nums[mid]) == (nums[0] > target)
                         ? nums[mid] // if mid and target is on the same side
                         : target < nums[0] // if mid and target is on the different side
                           ? Integer.MIN_VALUE // target on the left
                           : Integer.MAX_VALUE; // target on the right
      if (number == target) {
        return mid;
      }
      if (number > target) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return -1;
  }
}
