package ga.rugal.amazon.jumpgameii;

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
      arguments(new int[]{2, 3, 1, 1, 4}, 2),
      arguments(new int[]{2, 3, 0, 1, 4}, 2)
    );
  }

  @ParameterizedTest
  @MethodSource("source")
  public void test(final int[] input, final int expected) {
    Assertions.assertEquals(expected, this.solution.jump(input));
  }
}
