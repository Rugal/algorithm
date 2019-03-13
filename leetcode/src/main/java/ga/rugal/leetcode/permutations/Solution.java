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
package ga.rugal.leetcode.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/
 *
 * @author rugal
 */
public class Solution {

  private final List<List<Integer>> result = new ArrayList<>();

  private int[] numbers;

  public List<List<Integer>> permute(final int[] nums) {
    this.numbers = nums;
    this.result.clear();
    backtrack(new ArrayList<>());
    return this.result;
  }

  private void backtrack(final List<Integer> tempList) {
    //since it is not subset, it has to have full length
    if (tempList.size() == numbers.length) {
      this.result.add(new ArrayList<>(tempList));
      return;
    }
    for (int i = 0; i < numbers.length; i++) {
      //as we will go through the same value
      if (tempList.contains(numbers[i])) {
        continue; // element already exists, skip
      }
      tempList.add(numbers[i]);
      this.backtrack(tempList);
      tempList.remove(tempList.size() - 1);
    }
  }
}
