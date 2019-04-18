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
package ga.rugal.lintcode.amazon.mst;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author rugal
 */
public class SolutionTest {

  private final Solution solution = new Solution();

  public int a = 6;

  public int b = 3;

  public List<List<Integer>> c = Lists.list(Lists.list(1, 4),
                                            Lists.list(4, 5),
                                            Lists.list(2, 3));

  public int d = 4;

  public List<List<Integer>> e = Lists.list(Lists.list(1, 2, 5),
                                            Lists.list(1, 3, 10),
                                            Lists.list(1, 6, 2),
                                            Lists.list(5, 6, 5));

  public int expected = 7;

  @Test
  public void testGetMST() {
    Assert.assertEquals(this.expected, this.solution.getMST(a, b, c, d, e));
  }
}
