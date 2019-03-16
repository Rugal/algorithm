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
package ga.rugal.leetcode.combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combinations/
 *
 * @author rugal
 */
public class Solution {

  private int n;

  private int k;

  private final List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> combine(final int n, final int k) {
    this.n = n;
    this.k = k;
    this.backtrack(new ArrayList<>(), 0);
    return this.result;
  }

  private void backtrack(final List<Integer> temp, final int start) {
    if (temp.size() == this.k) {
      this.result.add(new ArrayList<>(temp));
      return;
    }

    for (int i = start + 1;
         i <= this.n && temp.size() < this.k;
         ++i) {
      temp.add(i);
      this.backtrack(temp, i);
      temp.remove(temp.size() - 1);
    }
  }
}
