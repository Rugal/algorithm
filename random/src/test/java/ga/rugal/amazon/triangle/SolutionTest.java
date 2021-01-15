package ga.rugal.amazon.triangle;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {

  private final Solution solution = new Solution();

  static Stream<Arguments> source() {
    return Stream.of(
      Arguments.of(List.of(List.of(2), List.of(3, 4), List.of(6, 5, 7), List.of(4, 1, 8, 3)), 11),
      Arguments.of(List.of(List.of(-10)), -10)
    );
  }

  @ParameterizedTest
  @MethodSource("source")
  public void minimumTotal(final List<List<Integer>> input, final int expected) {
    Assertions.assertEquals(expected, this.solution.minimumTotal(input));
  }
}
