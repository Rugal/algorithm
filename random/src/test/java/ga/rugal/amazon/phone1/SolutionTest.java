package ga.rugal.amazon.phone1;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {

  private final Solution solution = new Solution();

  static Stream<Arguments> source() {

    return Stream.of(
      Arguments.of(new char[][]{{'B', 'A'}, {'A', 'B'}, {'B', 'Y'}, {'T', 'H'}, {'A', 'B'}}, "BABY", true),
      Arguments.of(new char[][]{{'B', 'A'}, {'A', 'B'}, {'L', 'E'}, {'A', 'B'}}, "ABLE", false)
    );
  }

  @ParameterizedTest
  @MethodSource("source")
  public void testCoinGame(char[][] input, String target, boolean expected) {
    Assertions.assertEquals(expected, this.solution.coinGame(input, target));
  }
}
