/*
 * Copyright 2019 rugalbernstein.
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
package ga.rugal.leetcode.implementstrstr;

import ga.rugal.leetcode.implementstrstr.Solution;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author rugalbernstein
 */
public class SolutionTest {

  private final Solution solution = new Solution();

  @Ignore
  @Test
  public void testBuildNextTable() {
    final String pattern = "aabaabaaa";
    final int[] next = new int[]{0, 1, 0, 1, 2, 3, 4, 5, 2};
    Assert.assertArrayEquals(next, this.solution.buildNextTable(pattern));
  }

  @Test
  public void testStrStr() {
    Assert.assertEquals(9, this.solution.strStr("cbbcaababaabbaabc", "aabbaab"));
  }
}
