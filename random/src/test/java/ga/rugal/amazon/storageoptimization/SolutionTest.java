package ga.rugal.amazon.storageoptimization;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {

  private final Solution solution = new Solution();

  static Stream<Arguments> source() {
    return Stream.of(
      Arguments.of(3, 3, new int[]{2}, new int[]{2}, 4),
      Arguments.of(2, 2, new int[]{1}, new int[]{2}, 4),
      Arguments.of(3, 2, new int[]{1, 2, 3}, new int[]{1, 2}, 12),
      Arguments.of(6, 6, new int[]{4}, new int[]{2}, 4)
    );
  }

  @ParameterizedTest
  @MethodSource("source")
  public void storageOpt(final int n, final int m, final int[] h, final int[] v, final int expected) {
    Assertions.assertEquals(expected, this.solution.storageOpt(n, m, h, v));
  }
}
