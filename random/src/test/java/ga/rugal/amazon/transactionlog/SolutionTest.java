package ga.rugal.amazon.transactionlog;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {

  private final Solution solution = new Solution();

  static Stream<Arguments> source() {
    return Stream.of(
      Arguments.of(new String[]{"88 99 200", "88 99 300", "99 32 100", "12 12 15"}, 2, new String[]{"88", "99"})
    );
  }

  @ParameterizedTest
  @MethodSource("source")
  public void processLogFile(final String[] logs, final int threshold, final String[] expected) {
    Assertions.assertArrayEquals(expected, this.solution.processLogFile(logs, threshold));
  }
}
