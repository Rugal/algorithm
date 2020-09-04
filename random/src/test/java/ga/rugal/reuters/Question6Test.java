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

import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 *
 * @author u6105440
 */
public class Question6Test {

  static Stream<Arguments> source() {
    return Stream.of(
      arguments("aeiaaioaaaaeiiiiouuuooaauuaeiu", 13),
      arguments("aeiaaiooaauua", 0)
    );
  }

  @ParameterizedTest
  @MethodSource("source")
  public void longestVowelSubsequence(String input, int expected) {
    Assertions.assertEquals(expected, Question6.longestVowelSubsequence(input));
  }
}
