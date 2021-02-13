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
