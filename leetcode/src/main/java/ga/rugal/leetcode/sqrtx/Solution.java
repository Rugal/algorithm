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
package ga.rugal.leetcode.sqrtx;

/**
 * https://leetcode.com/problems/sqrtx/
 *
 * @author rugal
 */
public class Solution {

  public int mySqrt(final int x) {
    if (x == 0) {
      return 0;
    }
    int left = 1;
    for (int right = x; left < right;) {
      final int mid = (left + right) / 2;
      if (this.check(mid, x)) {
        return mid;
      }
      if (mid > x / mid) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

  /**
   * Just to check if {@code i^2 <= target < i+1^2}<BR>
   * Use division to avoid overflow.
   *
   * @param i
   * @param target
   *
   * @return
   */
  private boolean check(final int i, final int target) {
    return (i <= target / i) && ((i + 1) > target / (i + 1));
  }
}
