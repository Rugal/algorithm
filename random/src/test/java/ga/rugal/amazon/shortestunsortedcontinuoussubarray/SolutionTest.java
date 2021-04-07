package ga.rugal.amazon.shortestunsortedcontinuoussubarray;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {

  private final Solution solution = new Solution();

  static Stream<Arguments> source() {
    return Stream.of(
      Arguments.of(new int[]{2, 6, 4, 8, 10, 9, 15}, 5),
      Arguments.of(new int[]{1, 2, 3, 4}, 0),
      Arguments.of(new int[]{1}, 0)
    );
  }

  @ParameterizedTest
  @MethodSource("source")
  public void test(final int[] input, final int expected) {
    Assertions.assertEquals(expected, this.solution.findUnsortedSubarray(input));
  }
}
