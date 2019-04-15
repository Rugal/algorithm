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
package ga.rugal.leetcode.permutationsequence;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutation-sequence/
 *
 * @author rugal
 */
public class Solution {

  public String getPermutation(final int n, final int k) {
    //(n-1)! is the # of permutations if the 1st digit is done..
    //(n-2)! is the # of permutation  if the 2nd digit is done..
    //i.e. in a 1-dimensional array, there are N sets of (N-1)! entries,
    //and in each of those (N-1)! entries, there are (N-1) sets of (N-2)! entries...and so on.
    //so, this is a problem of progressiely dividing k to find where it falls in this array,
    //and expressing the k as the offsets at each level, which will indirectly be the sequence we desire

    final int[] fact = new int[n + 1];
    final List<Integer> number = new ArrayList<>();

    fact[0] = 1;
    for (int i = 1; i <= n; ++i) {
      fact[i] = fact[i - 1] * i;
      number.add(i);
    }

    final StringBuilder sb = new StringBuilder();
    for (int i = n - 1, r = k - 1; i >= 0; --i) {
      int index = r / fact[i];
      r -= index * fact[i];

      sb.append(number.get(index));
      number.remove(index);
    }
    return sb.toString();
  }
}
