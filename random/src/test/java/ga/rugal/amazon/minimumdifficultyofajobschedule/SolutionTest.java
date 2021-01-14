package ga.rugal.amazon.minimumdifficultyofajobschedule;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {

  private final Solution solution = new Solution();

  static Stream<Arguments> source() {
    return Stream.of(
      Arguments.of(new int[]{6, 5, 4, 3, 2, 1}, 2, 7),
      Arguments.of(new int[]{1, 1, 1}, 3, 3),
      Arguments.of(new int[]{7, 1, 7, 1, 7, 1}, 3, 15)
    );
  }

  @ParameterizedTest
  @MethodSource("source")
  public void minDifficulty(final int[] input, final int day, final int expected) {
    Assertions.assertEquals(expected, this.solution.minDifficulty(input, day));
  }
}
