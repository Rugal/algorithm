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
package ga.rugal.leetcode.permutationsii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations-ii
 *
 * @author rugal
 */
public class Solution {

  private List<List<Integer>> res;

  private int[] numbers;

  public List<List<Integer>> permuteUnique(int[] input) {
    this.numbers = input;
    this.res = new ArrayList<>();
    if (this.numbers == null || this.numbers.length == 0) {
      return res;
    }
    boolean[] used = new boolean[this.numbers.length];
    List<Integer> list = new ArrayList<>();
    Arrays.sort(this.numbers);
    dfs(used, list);
    return res;
  }

  private void dfs(boolean[] used, List<Integer> list) {
    if (list.size() == numbers.length) {
      res.add(new ArrayList<>(list));
      return;
    }
    for (int i = 0; i < numbers.length; i++) {
      if (used[i] || (i > 0 && numbers[i - 1] == numbers[i] && !used[i - 1])) {
        continue;
      }
      used[i] = true;
      list.add(numbers[i]);
      dfs(used, list);
      used[i] = false;
      list.remove(list.size() - 1);
    }
  }
}
