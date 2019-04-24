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
package ga.rugal.lintcode.amazon.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.lintcode.com/problem/subsets
 *
 * @author rugal
 */
public class Solution {

  /**
   * @param nums: A set of numbers
   *
   * @return A list of lists
   */
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> results = new ArrayList<>();
    Arrays.sort(nums);
    dfs(nums, 0, new ArrayList<>(), results);
    return results;
  }

  // 1. 递归的定义
  // 以 subset 开头的，配上 nums 以 index 开始的数所有组合放到 results 里
  private void dfs(int[] nums,
                   int index,
                   List<Integer> subset,
                   List<List<Integer>> results) {
    // 3. 递归的出口
    if (index == nums.length) {
      results.add(new ArrayList<>(subset));
      return;
    }

    // 2. 递归的拆解
    // (如何进入下一层)
    // 选了 nums[index]
    subset.add(nums[index]);
    dfs(nums, index + 1, subset, results);

    // 不选 nums[index]
    subset.remove(subset.size() - 1);
    dfs(nums, index + 1, subset, results);
  }
}
