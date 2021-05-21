package ga.rugal.wish.numberofdistinctislands;

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
      arguments(new int[][]{
      new int[]{1, 1, 0, 0, 1},
      new int[]{1, 0, 0, 0, 0},
      new int[]{1, 1, 0, 0, 1},
      new int[]{0, 1, 0, 1, 1}}, 3),
      arguments(new int[][]{
      new int[]{1, 1, 0, 0, 0},
      new int[]{1, 1, 0, 0, 0},
      new int[]{0, 0, 0, 1, 1},
      new int[]{0, 0, 0, 1, 1}}, 1)
    );
  }

  @ParameterizedTest
  @MethodSource("source")
  public void numberofDistinctIslands(final int[][] input, final int expected) {
    Assertions.assertEquals(expected, this.solution.numberofDistinctIslands(input));
  }
}
