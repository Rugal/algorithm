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
package ga.rugal.leetcode.subsetsii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets-ii/
 *
 * @author rugal
 */
public class Solution {

  private final List<List<Integer>> result = new ArrayList<>();

  private int[] numbers;

  public List<List<Integer>> subsetsWithDup(final int[] nums) {
    this.numbers = nums;
    Arrays.sort(nums);
    backtrack(new ArrayList<>(), 0);
    return this.result;
  }

  private void backtrack(final List<Integer> tempList, final int start) {
    this.result.add(new ArrayList<>(tempList));
    for (int i = start; i < numbers.length; i++) {
      //for duplication
      if (i > start && numbers[i] == numbers[i - 1]) {
        continue; // skip duplicates
      }
      tempList.add(numbers[i]);
      this.backtrack(tempList, i + 1);
      tempList.remove(tempList.size() - 1);
    }
  }
}
