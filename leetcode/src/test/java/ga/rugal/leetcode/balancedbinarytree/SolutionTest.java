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
package ga.rugal.leetcode.balancedbinarytree;

import java.util.Arrays;
import java.util.Collection;

import ga.rugal.leetcode.serializeanddeserializebinarytree.Codec;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author rugalbernstein
 */
@RunWith(Parameterized.class)
public class SolutionTest {

  private final Solution solution = new Solution();

  private final Codec c = new Codec();

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
      {"1,2,2,3,3,null,null,4,4", false},
      {"3,9,20,null,null,15,7", true},
      {"1,2,2,3,null,null,3,4,null,null,4", false},});

  }

  @Parameterized.Parameter(0)
  public String input;

  @Parameterized.Parameter(1)
  public boolean expected;

  @Test
  public void testIsBalanced() {
    Assert.assertEquals(expected, this.solution.isBalanced(this.c.deserialize(this.input)));
  }
}
