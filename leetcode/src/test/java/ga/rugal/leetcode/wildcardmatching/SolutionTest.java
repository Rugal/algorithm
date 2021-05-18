package ga.rugal.leetcode.wildcardmatching;

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
      arguments("adceb", "*a*b", true),
      arguments("cb", "?a", false),
      arguments("aa", "a", false),
      arguments("aa", "*", true),
      arguments("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "a*******b", false)
    );
  }

  @ParameterizedTest
  @MethodSource("source")
  public void isMatch(final String s, final String p, final boolean expected) {
    Assertions.assertEquals(expected, this.solution.isMatch(s, p));
  }
}
