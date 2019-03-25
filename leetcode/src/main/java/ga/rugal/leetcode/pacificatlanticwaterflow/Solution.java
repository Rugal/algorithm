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
package ga.rugal.leetcode.pacificatlanticwaterflow;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pacific-atlantic-water-flow/
 *
 * @author rugal
 */
public class Solution {

  private static final int[] X = {0, 0, 1, -1};

  private static final int[] Y = {1, -1, 0, 0};

  private int[][] matrix;

  public List<int[]> pacificAtlantic(int[][] matrix) {
    this.matrix = matrix;

    final List<int[]> result = new ArrayList<>();
    if (matrix.length == 0 || matrix[0].length == 0) {
      return result;
    }
    final boolean[][] pacific = new boolean[matrix.length][matrix[0].length];  // the pacific boolean table
    final boolean[][] atlantic = new boolean[matrix.length][matrix[0].length]; // the atlantic booean table
    //initially, all the top and left cells are flooded with pacific water
    //and all the right and bottom cells are flooded with atlantic water
    //we go around the matrix and try to flood the matrix from 4 side.
    for (int i = 0; i < matrix.length; i++) {
      water(pacific, new boolean[matrix.length][matrix[0].length], i, 0);
      water(atlantic, new boolean[matrix.length][matrix[0].length], i, matrix[0].length - 1);
    }
    for (int i = 0; i < matrix[0].length; i++) {
      water(pacific, new boolean[matrix.length][matrix[0].length], 0, i);
      water(atlantic, new boolean[matrix.length][matrix[0].length], matrix.length - 1, i);
    }
    //check the shared points among 2 tables
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (pacific[i][j] && atlantic[i][j]) {
          result.add(new int[]{i, j});
        }
      }
    }
    return result;
  }

  private boolean isValid(int i, int j) {
    return i >= 0
           && i < matrix.length
           && j >= 0
           && j < matrix[0].length;
  }

  private void water(boolean[][] wet, boolean[][] visited, int row, int column) {
    wet[row][column] = true;
    visited[row][column] = true;
    for (int i = 0; i < X.length; i++) {
      final int newRow = row + Y[i];
      final int newColumn = column + X[i];

      if (this.isValid(newRow, newColumn)
          && !visited[newRow][newColumn]
          && matrix[newRow][newColumn] >= matrix[row][column]) {
        water(wet, visited, newRow, newColumn);
      }
    }
  }
}
