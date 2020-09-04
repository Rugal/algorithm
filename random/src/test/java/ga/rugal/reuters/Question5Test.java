package ga.rugal.reuters;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 *
 * @author u6105440
 */
public class Question5Test {

  static Stream<Arguments> source() {
    return Stream.of(
      arguments(List.of(0, 1, 5, 5, 1, 1, 2, 1, 8, 6), 7, 3),
      arguments(List.of(0, 1, 5, 5, 45, 1, 2, 1, 2, 6), 7, -1),
      arguments(List.of(5, 3, 1, 4, 9), 4, 1)
    );
  }

  @ParameterizedTest
  @MethodSource("source")
  public void consecutiveSumExists(final List<Integer> input, final int target, final int expected) {
    Assertions.assertEquals(expected, Question5.ConsecutiveSumExists(input, target));
  }
}
