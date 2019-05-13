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
package ga.rugal.leetcode.triangle;

import java.util.List;

/**
 * https://leetcode.com/problems/triangle
 *
 * @author rugal
 */
public class Solution {

  public int minimumTotal(List<List<Integer>> triangle) {
    final int triangleSize = triangle.size();
    //so that the last row is all 0
    final int[][] sum = new int[triangleSize + 1][triangle.size() + 1];

    for (int row = triangleSize - 1; row >= 0; row--) {
      final List<Integer> get = triangle.get(row);
      for (int i = 0; i < get.size(); i++) {
        sum[row][i] = get.get(i) + Math.min(sum[row + 1][i],//choose from 2 below
                                            sum[row + 1][i + 1]);
      }
    }
    return sum[0][0];
  }
}
