package ga.rugal.amazon.robotboundedincircle;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {

  private final Solution solution = new Solution();

  static Stream<Arguments> source() {
    return Stream.of(
      Arguments.of("GGLLGG", true),
      Arguments.of("GG", false),
      Arguments.of("GL", true)
    );
  }

  @ParameterizedTest
  @MethodSource("source")
  public void isRobotBounded(final String input, final boolean expected) {
    Assertions.assertEquals(expected, this.solution.isRobotBounded(input));
  }
}
