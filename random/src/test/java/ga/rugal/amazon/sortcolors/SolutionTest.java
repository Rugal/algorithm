package ga.rugal.amazon.sortcolors;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {

  private final Solution solution = new Solution();

  static Stream<Arguments> source() {
    return Stream.of(
      Arguments.of(new int[]{2, 0, 2, 1, 1, 0}, new int[]{0, 0, 1, 1, 2, 2}),
      Arguments.of(new int[]{2, 0, 1}, new int[]{0, 1, 2}),
      Arguments.of(new int[]{0}, new int[]{0}),
      Arguments.of(new int[]{1}, new int[]{1})
    );
  }

  @ParameterizedTest
  @MethodSource("source")
  public void sortColors(final int[] input, final int[] expected) {
    this.solution.sortColors(input);
    Assertions.assertArrayEquals(expected, input);
  }
}
