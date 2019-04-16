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
package ga.rugal.leetcode.searchinrotatedsortedarrayii;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 *
 * @author rugal
 */
public class Solution {

  /**
   * 3 4 4 5 6 7 8 9 0 1 1 2 3<BR>
   * Unable to use the original solution because the first and last element can be same
   *
   * @param nums
   * @param target
   * @return
   */
  public boolean search(final int[] nums, final int target) {
    // note here end is initialized to len instead of (len-1)
    int start = 0, end = nums.length;
    while (start < end) {
      int mid = (start + end) / 2;
      if (nums[mid] == target) {
        return true;
      }
      if (nums[mid] > nums[start]) { // nums[start..mid] is sorted
        // check if target in left half
        if (target < nums[mid] && target >= nums[start]) {
          end = mid;
        } else {
          start = mid + 1;
        }
        continue;
      }
      if (nums[mid] < nums[start]) { // nums[mid..end] is sorted
        // check if target in right half
        if (target > nums[mid] && target < nums[start]) {
          start = mid + 1;
        } else {
          end = mid;
        }
        continue;
      }
      // have no idea about the array, but we can exclude nums[start] because nums[start] == nums[mid]
      start++;
    }
    return false;
  }
}
