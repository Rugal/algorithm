package ga.rugal.amazon.primeairtime;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {

  private final Solution solution = new Solution();

  static Stream<Arguments> source() {
    return Stream.of(
      Arguments.of(new int[][]{new int[]{1, 2000}, new int[]{2, 3000}, new int[]{3, 4000}},
                   new int[][]{new int[]{1, 5000}, new int[]{2, 3000}},
                   5000,
                   List.of(new int[]{1, 2})
      )
    );
  }

  @ParameterizedTest
  @MethodSource("source")
  public void getPair(final int[][] A,
                      final int[][] B,
                      final int target,
                      final List<int[]> expected) {
    this.solution.getPair(A, B, target);
  }
}
