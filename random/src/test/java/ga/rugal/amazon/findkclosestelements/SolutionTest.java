package ga.rugal.amazon.findkclosestelements;

import static org.junit.jupiter.params.provider.Arguments.arguments;

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
      arguments(new int[]{1, 2, 3, 4, 5}, 4, 3, List.of(1, 2, 3, 4)),
      arguments(new int[]{1, 2, 3, 4, 5}, 4, -1, List.of(1, 2, 3, 4)),
      arguments(new int[]{1}, 1, 1, List.of(1)),
      arguments(new int[]{-2, -1, 1, 2, 3, 4, 5}, 7, 3, List.of(-2, -1, 1, 2, 3, 4, 5)),
      arguments(new int[]{0, 0, 1, 2, 3, 3, 4, 7, 7, 8}, 3, 5, List.of(3, 3, 4)),
      arguments(new int[]{1, 2, 5, 5, 6, 6, 7, 7, 8, 9}, 7, 7, List.of(5, 5, 6, 6, 7, 7, 8))
    );
  }

  @ParameterizedTest
  @MethodSource("source")
  public void test(final int[] input, final int k, final int x, final List<Integer> expected) {
    Assertions.assertEquals(expected, this.solution.findClosestElements(input, k, x));
  }
}
