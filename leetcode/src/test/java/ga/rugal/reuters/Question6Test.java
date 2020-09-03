/*
 * Copyright 2020 u6105440.
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
package ga.rugal.reuters;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author u6105440
 */
@RunWith(Parameterized.class)
public class Question6Test {

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
      {"aeiaaioaaaaeiiiiouuuooaauuaeiu", 13},
      {"aeiaaiooaauua", 0}});
  }

  @Parameterized.Parameter(0)
  public String input;

  @Parameterized.Parameter(1)
  public int expected;

  @Test
  public void longestVowelSubsequence() {
    Assert.assertEquals(this.expected, Question6.longestVowelSubsequence(this.input));
  }
}
