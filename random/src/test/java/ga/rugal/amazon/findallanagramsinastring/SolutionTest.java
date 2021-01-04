package ga.rugal.amazon.findallanagramsinastring;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 *
 * @author rugalbernstein
 */
public class SolutionTest {

  private final Solution solution = new Solution();

  static Stream<Arguments> source() {
    return Stream.of(
      arguments("cbaebabacd", "abc", new int[]{0, 6})
    );
  }

  @ParameterizedTest
  @MethodSource("source")
  public void testFindAnagrams(final String s, final String p, final int[] expected) {
    Assertions.assertArrayEquals(expected, this.solution.findAnagrams(s, p).stream().mapToInt(x -> x).toArray());
  }
}
