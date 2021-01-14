package ga.rugal.amazon.itemincontainers;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {

  private final Solution solution = new Solution();

  static Stream<Arguments> source() {
    return Stream.of(
      Arguments.of("|**|*|*", new int[]{1, 1}, new int[]{5, 6}, new int[]{2, 3}),
      Arguments.of("*|*|", new int[]{1}, new int[]{3}, new int[]{0}),
      Arguments.of("*|*|*|", new int[]{1}, new int[]{6}, new int[]{2})
    );
  }

  @ParameterizedTest
  @MethodSource("source")
  public void numberOfItems(final String text, final int[] start, final int[] end, final int[] expected) {
    Assertions.assertArrayEquals(expected, this.solution.numberOfItems(text, start, end));
  }
}
