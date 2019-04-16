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
package ga.rugal.leetcode.spiralmatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix/
 *
 * @author rugal
 */
public class Solution {

  public List<Integer> spiralOrder(final int[][] matrix) {
    final List ans = new ArrayList();
    if (matrix.length == 0) {
      return ans;
    }
    int r1 = 0, r2 = matrix.length - 1;
    int c1 = 0, c2 = matrix[0].length - 1;
    while (r1 <= r2 && c1 <= c2) {
      //top row
      for (int c = c1; c <= c2; c++) {
        ans.add(matrix[r1][c]);
      }
      //right column
      for (int r = r1 + 1; r <= r2; r++) {
        ans.add(matrix[r][c2]);
      }
      //for odd number of row and column, there is a case that only have one row left
      if (r1 < r2 && c1 < c2) {
        //bottom row
        for (int c = c2 - 1; c > c1; c--) {
          ans.add(matrix[r2][c]);
        }
        //left column
        for (int r = r2; r > r1; r--) {
          ans.add(matrix[r][c1]);
        }
      }
      r1++;
      c1++;
      r2--;
      c2--;
    }
    return ans;
  }
}
