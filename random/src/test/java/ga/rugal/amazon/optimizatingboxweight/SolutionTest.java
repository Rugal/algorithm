package ga.rugal.amazon.optimizatingboxweight;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {

  private final Solution solution = new Solution();

  static Stream<Arguments> source() {
    return Stream.of(
//      Arguments.of(new int[]{5, 3, 2, 4, 1, 2}, new int[]{4, 5}),
      Arguments.of(new int[]{1, 1, 2, 1}, new int[]{1, 2}),
      Arguments.of(new int[]{1, 2, 5, 8, 4}, new int[]{5, 8})
    );
  }

  @ParameterizedTest
  @MethodSource("source")
  public void optimizeBoxWeight(final int[] input, final int[] expected) {
    Assertions.assertArrayEquals(expected, this.solution.optimizeBoxWeight(input));
  }
}
