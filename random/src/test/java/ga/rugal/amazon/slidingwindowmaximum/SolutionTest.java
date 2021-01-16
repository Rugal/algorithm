package ga.rugal.amazon.slidingwindowmaximum;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {

  private final Solution solution = new Solution();

  static Stream<Arguments> source() {
    return Stream.of(
      Arguments.of(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3, new int[]{3, 3, 5, 5, 6, 7}),
      Arguments.of(new int[]{1}, 1, new int[]{1}),
      Arguments.of(new int[]{1, -1}, 1, new int[]{1, -1}),
      Arguments.of(new int[]{9, 11}, 2, new int[]{11}),
      Arguments.of(new int[]{4, -2}, 2, new int[]{4})
    );
  }

  @ParameterizedTest
  @MethodSource("source")
  public void maxSlidingWindow(final int[] input, final int size, final int[] expected) {
    Assertions.assertArrayEquals(expected, this.solution.maxSlidingWindow(input, size));
  }
}
