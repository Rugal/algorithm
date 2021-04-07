package ga.rugal.amazon.coinchange;

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
      arguments(new int[]{1, 2, 5}, 11, 3),
      arguments(new int[]{2}, 3, -1),
      arguments(new int[]{1}, 0, 0),
      arguments(new int[]{1}, 2, 2)
    );
  }

  @ParameterizedTest
  @MethodSource("source")
  public void test(final int[] input, final int amount, final int expected) {
    Assertions.assertEquals(expected, this.solution.coinChange(input, amount));
  }
}
