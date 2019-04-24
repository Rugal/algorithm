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
package ga.rugal.lintcode.amazon.wordladderii;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

import org.assertj.core.util.Sets;
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
      {"hit", "cog", Sets.newTreeSet("hot", "dot", "dog", "lot", "log")},});
  }

  @Parameterized.Parameter(0)
  public String start;

  @Parameterized.Parameter(1)
  public String stop;

  @Parameterized.Parameter(2)
  public Set<String> dict;

  @Test
  public void testFindLadders() {
    this.solution.findLadders(start, stop, dict);
  }
}
