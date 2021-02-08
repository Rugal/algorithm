/*
 * Copyright 2021 u6105440.
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
package ga.rugal.amazon.utilizationchecks;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {

  private final Solution solution = new Solution();

  static Stream<Arguments> source() {
    return Stream.of(
      Arguments.of(2, new int[]{25, 23, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 76, 80}, 2),
      Arguments.of(1, new int[]{5, 10, 80}, 2),
      Arguments.of(5, new int[]{30, 5, 4, 8, 19, 89}, 3)
    );
  }

  @ParameterizedTest
  @MethodSource("source")
  public void finalInstances(final int instance, final int[] input, final int expected) {
    Assertions.assertEquals(expected, this.solution.finalInstances(instance, input));
  }
}
