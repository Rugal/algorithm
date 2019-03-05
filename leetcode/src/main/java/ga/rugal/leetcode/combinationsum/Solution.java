/*
 * Copyright 2019 rugalbernstein.
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
package ga.rugal.leetcode.combinationsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author rugalbernstein
 */
public class Solution {

  private int[] candidates;

  private int target;

  private List<List<Integer>> result;

  public List<List<Integer>> combinationSum(final int[] candidates, final int target) {
    this.candidates = candidates;
    this.target = target;
    this.result = new ArrayList<>();

    Arrays.sort(candidates);

    this.backtrack(new ArrayList<>(), 0, 0);
    return result;
  }

  private void backtrack(final List<Integer> temp, final int start, final int sum) {
    if (sum == this.target) {
      this.result.add(new ArrayList<>(temp));
      return;
    }

    for (int i = start; i < this.candidates.length && sum + this.candidates[i] <= target; ++i) {
      final List<Integer> arrayList = new ArrayList<>(temp);
      arrayList.add(this.candidates[i]);
      this.backtrack(arrayList, i, sum + this.candidates[i]);
    }
  }
}
