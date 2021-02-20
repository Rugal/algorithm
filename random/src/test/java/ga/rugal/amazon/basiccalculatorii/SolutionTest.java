package ga.rugal.amazon.basiccalculatorii;

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
//      arguments("3+2*2", 7),
//      arguments(" 3/2 ", 1),
//      arguments(" 3+5 / 2 ", 5),
//      arguments(" 0 ", 0),
      arguments("1*2-3/4+5*6-7*8+9/10", -24)
    );
  }

  @ParameterizedTest
  @MethodSource("source")
  public void calculate(final String input, final int expected) {
    Assertions.assertEquals(expected, this.solution.calculate(input));
  }
}
