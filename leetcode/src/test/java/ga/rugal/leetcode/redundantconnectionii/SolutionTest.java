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
package ga.rugal.leetcode.redundantconnectionii;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
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
      {new int[][]{{1, 2}, {1, 3}, {2, 3}}, new int[]{2, 3}},
      {new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}}, new int[]{4, 1}}
    });
  }

  @Parameterized.Parameter(0)
  public int[][] input;

  @Parameterized.Parameter(1)
  public int[] expected;

  @Test
  public void testFindRedundantDirectedConnection() {
    Assert.assertArrayEquals(this.expected, this.solution.findRedundantDirectedConnection(input));
  }
}
