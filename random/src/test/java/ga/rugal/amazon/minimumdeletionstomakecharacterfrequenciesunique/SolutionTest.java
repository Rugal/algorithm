package ga.rugal.amazon.minimumdeletionstomakecharacterfrequenciesunique;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {

  private final Solution solution = new Solution();

  static Stream<Arguments> source() {
    return Stream.of(
      Arguments.of("aab", 0),
      Arguments.of("aaabbbcc", 2),
      Arguments.of("ceabaacb", 2),
      Arguments.of("abcabc", 3),
      Arguments.of("bbcebab", 2)
    );
  }

  @ParameterizedTest
  @MethodSource("source")
  public void minDeletions(final String input, final int expected) {
    Assertions.assertEquals(expected, this.solution.minDeletions(input));
  }
}
