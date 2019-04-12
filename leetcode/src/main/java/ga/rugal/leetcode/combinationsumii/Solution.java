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
package ga.rugal.leetcode.combinationsumii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-ii/
 *
 * @author rugal
 */
public class Solution {

  private int[] candidates;

  private int target;

  private List<List<Integer>> result;

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    this.candidates = candidates;
    this.target = target;
    this.result = new ArrayList<>();

    Arrays.sort(candidates);

    this.backtrack(new boolean[this.candidates.length], new ArrayList<>(), 0, 0);
    return result;
  }

  private void backtrack(boolean[] used, List<Integer> temp, int start, int sum) {
    if (sum == this.target) {
      this.result.add(new ArrayList<>(temp));
      return;
    }

    for (int i = start; i < this.candidates.length && sum + this.candidates[i] <= target; ++i) {
      if (used[i] //prevent same [index] from being used
          || (i > 0 //but allow same [value] to appear in one candidate
              && this.candidates[i - 1] == this.candidates[i]
              && !used[i - 1])) {
        continue;
      }
      final List<Integer> arrayList = new ArrayList<>(temp);
      arrayList.add(this.candidates[i]);
      used[i] = true;
      this.backtrack(used, arrayList, i, sum + this.candidates[i]);
      arrayList.remove(arrayList.size() - 1);
      used[i] = false;
    }
  }
}
