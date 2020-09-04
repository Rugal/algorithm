package ga.rugal.reuters;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 *
 * @author Rugal
 */
public class Question4Test {

  static Stream<Arguments> source() {
    return Stream.of(
      arguments('l', "helloworld"),
      arguments('a', "bbbaaaa"),
      arguments('b', "bbbaaa"),
      arguments('a', "a"),
      arguments('c', "abcc"),
      arguments('a', "abc"),
      arguments('b', "abbc")
    );
  }

  @ParameterizedTest
  @MethodSource("source")
  public void maximumOccurringCharacter(final char expected, final String input) {
    Assertions.assertEquals(expected, Question4.maximumOccurringCharacter(input));
  }
}
