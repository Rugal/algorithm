package ga.rugal.amazon.besttimetobuyandsellstock;

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
      arguments(new int[]{7,1,5,3,6,4}, 5),
      arguments(new int[]{7,6,4,3,1}, 0)
    );
  }

  @ParameterizedTest
  @MethodSource("source")
  public void maxProfit(final int[] input, final int expected) {
    Assertions.assertEquals(expected, this.solution.maxProfit(input));
  }
}
