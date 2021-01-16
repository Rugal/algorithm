package ga.rugal.amazon.courseschedule;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {

  private final Solution solution = new Solution();

  static Stream<Arguments> source() {
    return Stream.of(
      arguments(2, new int[][]{new int[]{1, 0}}, true),
      arguments(2, new int[][]{new int[]{1, 0}, new int[]{0, 1}}, false)
    );
  }

  @ParameterizedTest
  @MethodSource("source")
  public void canFinish(final int number, final int[][] prerequisites, final boolean expected) {
    Assertions.assertEquals(expected, this.solution.canFinish(number, prerequisites));
  }
}
