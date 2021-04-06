package ga.rugal.reuters.constructionmanagement;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ResultTest {

  static Stream<Arguments> source() {
    return Stream.of(
//                                arguments(List.of(
//                                                            List.of(1, 2, 2),
//                                                            List.of(2, 2, 1),
//                                                            List.of(2, 1, 2)), 3),
//                                arguments(List.of(
//                                                            List.of(1, 2, 2),
//                                                            List.of(2, 3, 3),
//                                                            List.of(3, 3, 1)), 5),
                                arguments(List.of(
                                                            List.of(49, 73, 58),
                                                            List.of(30, 72, 44),
                                                            List.of(78, 23, 9),
                                                            List.of(40, 65, 92),
                                                            List.of(42, 87, 3),
                                                            List.of(27, 29, 40),
                                                            List.of(12, 3, 69),
                                                            List.of(9, 57, 60),
                                                            List.of(33, 99, 78),
                                                            List.of(16, 35, 97)), 273)

    );
  }

  @ParameterizedTest
  @MethodSource("source")
  public void test(final List<List<Integer>> input, final int expected) {
    Assertions.assertEquals(expected, Result.minCost(input));
  }
}
