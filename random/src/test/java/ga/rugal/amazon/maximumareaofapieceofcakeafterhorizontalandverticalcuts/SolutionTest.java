package ga.rugal.amazon.maximumareaofapieceofcakeafterhorizontalandverticalcuts;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {

  private final Solution solution = new Solution();

  static Stream<Arguments> source() {
    return Stream.of(
      Arguments.of(5, 4, new int[]{1, 2, 4}, new int[]{1, 3}, 4),
      Arguments.of(5, 4, new int[]{3, 1}, new int[]{1}, 6)
    );
  }

  @ParameterizedTest
  @MethodSource("source")
  public void maxArea(final int h,
                      final int w,
                      final int[] horizontalCuts,
                      final int[] verticalCuts,
                      final int expected) {
    Assertions.assertEquals(expected, this.solution.maxArea(h, w, horizontalCuts, verticalCuts));
  }
}
