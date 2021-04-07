package ga.rugal.amazon.typeahead;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TypeaheadTest {

  static Stream<Arguments> source() {
    return Stream.of(
      arguments(Set.of("Jason Zhang", "James Yu", "Lee Zhang", "Yanny Li"), "Zhang", List.of("Jason Zhang", "Lee Zhang"))
    );
  }

  @ParameterizedTest
  @MethodSource("source")
  public void test(final Set<String> input, final String key, final List<String> expected) {
    final var solution = new Typeahead(input);
    final List<String> result = solution.search(key);
    for (int i = 0; i < expected.size(); ++i) {
      Assertions.assertEquals(expected.get(i), result.get(i));
    }
  }
}
