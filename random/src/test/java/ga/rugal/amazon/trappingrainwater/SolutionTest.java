package ga.rugal.amazon.trappingrainwater;

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
      arguments(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}, 6),
      arguments(new int[]{4, 2, 0, 3, 2, 5}, 9)
    );
  }

  @ParameterizedTest
  @MethodSource("source")
  public void test(final int[] height, final int expected) {

    Assertions.assertEquals(expected, this.solution.trap(height));
  }
}
