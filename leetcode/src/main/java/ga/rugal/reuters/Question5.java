/*
 * Copyright 2020 u6105440.
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
package ga.rugal.reuters;

import java.util.List;

/**
 *
 * @author Rugal
 */
public class Question5 {

  /**
   * Complete the 'ConsecutiveSumExists' function below.The function is expected to return an
   * INTEGER. The function accepts following parameters: <BR>
   * 1. INTEGER_ARRAY nums <BR>
   * 2. INTEGER target
   *
   * @param nums
   * @param target
   *
   * @return
   */
  public static int ConsecutiveSumExists(final List<Integer> nums, final int target) {
    if (nums.isEmpty()) {
      return -1;
    }
    int sum = nums.get(0);
    for (int left = 0, right = 0; right < nums.size();) {
      if (sum == target) {
        return left;
      }
      if (sum < target) {
        if (right + 1 >= nums.size()) {
          // in case right is length - 1
          return -1;
        }
        // not enough, step forward
        sum += nums.get(++right);
      } else {
        // too much, need one element less
        sum -= nums.get(left++);
        if (left > right) {
          // in case one of the element is extremely big
          right = left;
          sum = nums.get(left);
        }
      }
    }
    return -1;
  }

}
