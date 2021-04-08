package ga.rugal.amazon.jumpgameiii;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {

  private final Solution solution = new Solution();

  static Stream<Arguments> source() {
    return Stream.of(
      arguments(new int[]{4, 2, 3, 0, 3, 1, 2}, 5, true),
      arguments(new int[]{4, 2, 3, 0, 3, 1, 2}, 0, true),
      arguments(new int[]{3, 0, 2, 1, 2}, 2, false)
    );
  }

  @ParameterizedTest
  @MethodSource("source")
  public void test(final int[] input, final int start, final boolean expected) {
    Assertions.assertEquals(expected, this.solution.canReach(input, start));
  }
}
