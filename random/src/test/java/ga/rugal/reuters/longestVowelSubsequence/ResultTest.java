package ga.rugal.reuters.longestVowelSubsequence;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ResultTest {

  static Stream<Arguments> source() {
    return Stream.of(
      arguments("aeiaaioaaaaeiiiiouuuooaauuaeiu", 13),
      arguments("aeiaaiooaauua", 0)
    );
  }

  @ParameterizedTest
  @MethodSource("source")
  public void test(final String input, final int expected) {
    Assertions.assertEquals(expected, Result.longestVowelSubsequence(input));
  }
}
