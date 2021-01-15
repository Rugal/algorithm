package ga.rugal.amazon.romantointeger;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {

  private final Solution solution = new Solution();

  static Stream<Arguments> source() {
    return Stream.of(
      Arguments.of("III", 3),
      Arguments.of("IV", 4),
      Arguments.of("LVIII", 58),
      Arguments.of("MCMXCIV", 1994)
    );
  }

  @ParameterizedTest
  @MethodSource("source")
  public void romanToInt(final String s, final int expected) {
    Assertions.assertEquals(expected, this.solution.romanToInt(s));
  }
}
