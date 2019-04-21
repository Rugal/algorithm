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
package ga.rugal.lintcode.amazon.themostfrequentword;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

import org.assertj.core.util.Sets;
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
      {"Jimmy has an apple, it is on the table, he like it",
       Sets.newTreeSet("a", "an", "the"), "it"},});
  }

  @Parameterized.Parameter(0)
  public String input;

  @Parameterized.Parameter(1)
  public Set<String> set;

  @Parameterized.Parameter(2)
  public String expected;

  @Test
  public void testFrequentWord() {
    Assert.assertEquals(this.expected, this.solution.frequentWord(input, set));
  }
}
