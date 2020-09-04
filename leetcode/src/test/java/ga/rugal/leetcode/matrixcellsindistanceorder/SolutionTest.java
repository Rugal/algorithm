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
package ga.rugal.leetcode.matrixcellsindistanceorder;

import ga.rugal.leetcode.matrixcellsindistanceorder.Solution;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author rugal
 */
@RunWith(Parameterized.class)
public class SolutionTest {

  private final Solution solution = new Solution();

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
      {2, 2, 0, 1},});
  }

  @Parameterized.Parameter(0)
  public int R;

  @Parameterized.Parameter(1)
  public int C;

  @Parameterized.Parameter(2)
  public int x;

  @Parameterized.Parameter(3)
  public int y;

  @Test
  public void testAllCellsDistOrder() {
    this.solution.allCellsDistOrder(R, C, x, y);
  }
}
