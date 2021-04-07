package ga.rugal.amazon.kclosestpointstoorigin;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {

  private final Solution solution = new Solution();

  static Stream<Arguments> source() {
    return Stream.of(
      Arguments.of(new int[][]{{1, 3}, {-2, 2}}, 1, new int[][]{{-2, 2}}),
      Arguments.of(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2, new int[][]{{3, 3}, {-2, 4}}),
      Arguments.of(new int[][]{{-2, -6}, {-7, -2}, {-9, 6}, {10, 3}, {-8, 1}, {2, 8}}, 5, new int[][]{{-2, -6}, {-7, -2}, {-8, 1}, {2, 8}, {10, 3}}),
      Arguments.of(new int[][]{{-2, 5}, {7, -2}, {-8, 0}, {2, 9}, {-1, 3}, {-3, 9}, {-6, 8}, {-5, -5}}, 7, new int[][]{{-1, 3}, {-2, 5}, {-5, -5}, {7, -2}, {-8, 0}, {2, 9}, {-3, 9}})
    );
  }

  @ParameterizedTest
  @MethodSource("source")
  public void test(final int[][] input, final int k, final int[][] expected) {
    Assertions.assertArrayEquals(expected, this.solution.kClosest(input, k));
  }
}
