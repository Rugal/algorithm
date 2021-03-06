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
package ga.rugal.leetcode.coursescheduleii;

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
      {2,
       new int[][]{
         new int[]{1, 0}
       },
       new int[]{0, 1}
      },
      {
        2,
        new int[][]{
          new int[]{1, 0},
          new int[]{0, 1}
        },
        new int[]{}
      }
    });
  }

  @Parameterized.Parameter(0)
  public int num;

  @Parameterized.Parameter(1)
  public int[][] pre;

  @Parameterized.Parameter(2)
  public int[] expected;

  @Test
  public void testFindOrder() {
    Assert.assertArrayEquals(this.expected, this.solution.findOrder(this.num, this.pre));
  }
}
