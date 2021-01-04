package ga.rugal.amazon.itemincontainers;

import java.util.stream.IntStream;

/**
 * https://aonecode.com/amazon-online-assessment-items-in-containers
 *
 * @author rugal
 */
public class Solution {

  private int[] build(final String text) {
    final var map = new int[text.length() + 1];
    int i = 0;
    for (; i < text.length(); ++i) {
      if (text.charAt(i) == '|') {
        break;
      }
    }
    int count = 0;
    int last = 0;
    for (; i < text.length(); ++i) {
      final var c = text.charAt(i);
      if ('|' == c) {
        last = map[i + 1] = last + count;
        count = 0;
      } else {
        ++count;
        map[i + 1] = last;
      }
    }
    return map;
  }

  /**
   *
   * @param table table built
   * @param start 1
   * @param end   5
   *
   * @return
   */
  private int getNumber(final int[] table, final int start, final int end) {
    return table[end] - table[start];
  }

  /**
   *
   * @param text  '|**|*|*'
   * @param start [1, 1]
   * @param end   [5, 6]
   *
   * @return [2, 3]
   */
  public int[] numberOfItems(final String text, final int[] start, final int[] end) {
    final var map = this.build(text);
    return IntStream
      .range(0, start.length)
      .map(i -> this.getNumber(map, start[i], end[i]))
      .toArray();
  }
}
