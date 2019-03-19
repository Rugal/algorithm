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
package ga.rugal.leetcode.binarywatch;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-watch/
 *
 * @author rugal
 */
public class Solution {

  public List<String> readBinaryWatch(final int num) {
    List<String> res = new ArrayList<>();
    int[] hour = new int[]{8, 4, 2, 1}, minute = new int[]{32, 16, 8, 4, 2, 1};
    for (int i = 0; i <= num; i++) {
      //get possible combinations for both hour and minute
      List<Integer> hourCombination = generateDigit(hour, i);
      List<Integer> minuteCombination = generateDigit(minute, num - i);
      for (int num1 : hourCombination) {
        if (num1 >= 12) {
          continue;
        }
        for (int num2 : minuteCombination) {
          if (num2 >= 60) {
            continue;
          }
          res.add(num1 + ":" + (num2 < 10 ? "0" + num2 : num2));
        }
      }
    }
    return res;
  }

  private List<Integer> generateDigit(final int[] nums, final int count) {
    final List<Integer> res = new ArrayList<>();
    generateDigitHelper(nums, count, 0, 0, res);
    return res;
  }

  private void generateDigitHelper(int[] nums, int count, int pos, int sum, List<Integer> res) {
    if (count == 0) {
      res.add(sum);
      return;
    }

    for (int i = pos; i < nums.length; i++) {
      generateDigitHelper(nums, count - 1, i + 1, sum + nums[i], res);
    }
  }
}
