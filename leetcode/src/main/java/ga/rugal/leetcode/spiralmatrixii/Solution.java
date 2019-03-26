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
package ga.rugal.leetcode.spiralmatrixii;

/**
 * https://leetcode.com/problems/spiral-matrix/
 *
 * @author rugal
 */
public class Solution {

  public int[][] generateMatrix(int n) {
    if (n == 0) {
      return null;
    }
    final int[][] result = new int[n][n];
    int r1 = 0, r2 = n - 1;
    int c1 = 0, c2 = n - 1;

    for (int count = 1; r1 <= r2 && c1 <= c2;) {
      for (int c = c1; c <= c2; c++) {
        result[r1][c] = count++;
      }
      for (int r = r1 + 1; r <= r2; r++) {
        result[r][c2] = count++;
      }
      if (r1 < r2 && c1 < c2) {
        for (int c = c2 - 1; c > c1; c--) {
          result[r2][c] = count++;
        }
        for (int r = r2; r > r1; r--) {
          result[r][c1] = count++;
        }
      }
      r1++;
      c1++;
      r2--;
      c2--;
    }
    return result;
  }
}
