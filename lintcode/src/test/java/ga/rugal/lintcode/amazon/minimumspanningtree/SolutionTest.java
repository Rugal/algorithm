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
package ga.rugal.lintcode.amazon.minimumspanningtree;

import java.util.List;

import ga.rugal.lintcode.Connection;

import org.assertj.core.util.Lists;
import org.junit.Test;

/**
 *
 * @author rugal
 */
public class SolutionTest {

  private final Solution solution = new Solution();

  public List<Connection> a = Lists.list(new Connection("Acity", "Bcity", 1),
                                         new Connection("Acity", "Ccity", 2),
                                         new Connection("Bcity", "Ccity", 3));

  @Test
  public void testLowestCost() {
    this.solution.lowestCost(a);
  }
}
