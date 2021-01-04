package ga.rugal.amazon.transactionlog;

import java.util.HashMap;
import java.util.Map;

/**
 * https://aonecode.com/amazon-online-assessment-transaction-logs
 *
 * @author rugal
 */
public class Solution {

  private void increment(final Map<Integer, Integer> usage, final String index) {
    final int v = Integer.parseInt(index);
    usage.put(v, usage.getOrDefault(v, 0) + 1);
  }

  /**
   *
   * @param logs      ["88 99 200", "88 99 300", "99 32 100", "12 12 15"]
   * @param threshold 2
   *
   * @return
   */
  public String[] processLogFile(String[] logs, int threshold) {
    final Map<Integer, Integer> usage = new HashMap<>();
    for (var log : logs) {
      final var split = log.split(" ");
      final var from = split[0];
      final var to = split[1];
      if (!from.equals(to)) {
        // from
        // add both from & to if they are different
        this.increment(usage, from);
      }
      // to
      this.increment(usage, to);
    }

    return usage.entrySet().stream()
      .filter(entry -> entry.getValue() >= threshold)
      .map(entry -> entry.getKey())
      .sorted()
      .map(i -> Integer.toString(i))
      .toArray(String[]::new);
  }
}
