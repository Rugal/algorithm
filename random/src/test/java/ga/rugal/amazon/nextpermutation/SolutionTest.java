package ga.rugal.amazon.nextpermutation;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {

  private final Solution solution = new Solution();

  static Stream<Arguments> source() {
    return Stream.of(
      Arguments.of(new int[]{1, 2, 3}, new int[]{1, 3, 2}),
      Arguments.of(new int[]{3, 2, 1}, new int[]{1, 2, 3}),
      Arguments.of(new int[]{1, 1, 5}, new int[]{1, 5, 1}),
      Arguments.of(new int[]{1}, new int[]{1})
    );
  }

  @ParameterizedTest
  @MethodSource("source")
  public void nextPermutation(final int[] input, final int[] expected) {
    this.solution.nextPermutation(input);
    Assertions.assertArrayEquals(expected, input);
  }
}
