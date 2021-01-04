/*
 * Copyright 2021 rugal.
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
package ga.rugal.amazon.itemincontainers;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {

  private final Solution solution = new Solution();

  static Stream<Arguments> source() {
    return Stream.of(
      Arguments.of("|**|*|*", new int[]{1, 1}, new int[]{5, 6}, new int[]{2, 3}),
      Arguments.of("*|*|", new int[]{1}, new int[]{3}, new int[]{0}),
      Arguments.of("*|*|*|", new int[]{1}, new int[]{6}, new int[]{2})
    );
  }

  @ParameterizedTest
  @MethodSource("source")
  public void numberOfItems(final String text, final int[] start, final int[] end, final int[] expected) {
    Assertions.assertArrayEquals(expected, this.solution.numberOfItems(text, start, end));
  }
}
