package ga.rugal.amazon.searchinrotatedsortedarrayii;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {

  private final Solution solution = new Solution();

  static Stream<Arguments> source() {
    return Stream.of(
      Arguments.of(new int[]{2, 5, 6, 0, 0, 1, 2}, 0, true),
      Arguments.of(new int[]{2, 5, 6, 0, 0, 1, 2}, 3, false)
    );
  }

  @ParameterizedTest
  @MethodSource("source")
  public void search(final int[] input, final int target, final boolean expected) {
    Assertions.assertEquals(expected, this.solution.search(input, target));
  }
}
