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
package ga.rugal.leetcode.mergesortedarray;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 *
 * @author rugal
 */
public class Solution {

  public void merge(int[] nums1, int m, int[] nums2, int n) {

    int curr = m + n - 1;
    m--;
    n--;
    while (n >= 0) {
      if (m >= 0 && (nums1[m] >= nums2[n])) {
        nums1[curr--] = nums1[m--];
      } else {
        nums1[curr--] = nums2[n--];
      }
    }
  }
}
