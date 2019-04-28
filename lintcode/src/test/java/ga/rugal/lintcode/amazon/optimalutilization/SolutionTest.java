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
package ga.rugal.lintcode.amazon.optimalutilization;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.assertj.core.util.Lists;
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
      {20,
       Lists.list(Lists.list(1, 8),
                  Lists.list(2, 7),
                  Lists.list(3, 14)),
       Lists.list(Lists.list(1, 5),
                  Lists.list(2, 10),
                  Lists.list(3, 14))
      },
      {20,
       Lists.list(Lists.list(1, 8),
                  Lists.list(2, 7),
                  Lists.list(3, 14)),
       Lists.list(Lists.list(1, 5),
                  Lists.list(2, 10),
                  Lists.list(3, 14),
                  Lists.list(4, 6))
      },
      {20,
       Lists.list(Lists.list(1, 8),
                  Lists.list(2, 7),
                  Lists.list(3, 14),
                  Lists.list(4, 14)),
       Lists.list(Lists.list(1, 5),
                  Lists.list(2, 10),
                  Lists.list(3, 14))
      },
      {1,
       Lists.list(Lists.list(1, 8),
                  Lists.list(2, 7),
                  Lists.list(3, 14),
                  Lists.list(4, 14)),
       Lists.list(Lists.list(1, 5),
                  Lists.list(2, 10),
                  Lists.list(3, 14))
      }});
  }

  @Parameterized.Parameter(0)
  public int input;

  @Parameterized.Parameter(1)
  public List<List<Integer>> forward;

  @Parameterized.Parameter(2)
  public List<List<Integer>> backward;

  @Test
  public void testOptimalUtilization() {
    System.out.println("BEGIN");
    for (List<Integer> list : this.solution.optimalUtilization(this.input, this.forward, this.backward)) {
      for (int i : list) {
        System.out.print(i + " ");
      }
      System.out.println();
    }
  }
}
