package ga.rugal.amazon.intersectionoftwoarraysii;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 *
 * @author rugal
 */
public class SolutionTest {

  private final Solution solution = new Solution();

  static Stream<Arguments> source() {
    return Stream.of(
      arguments(new int[]{1, 2, 2, 1}, new int[]{2, 2}, new int[]{2, 2}),
      arguments(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}, new int[]{9, 4})
    );
  }

  @ParameterizedTest
  @MethodSource("source")
  public void testIntersect(final int[] left, final int[] right, final int[] expected) {
    Assertions.assertArrayEquals(expected, this.solution.intersect(left, right));
  }
}
