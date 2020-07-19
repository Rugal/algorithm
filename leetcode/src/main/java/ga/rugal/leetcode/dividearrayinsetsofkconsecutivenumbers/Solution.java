package ga.rugal.leetcode.dividearrayinsetsofkconsecutivenumbers;

import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
 *
 * @author rugal
 */
public class Solution {

  private void reduceOrRemove(final TreeMap<Integer, Integer> map, final int key) {
    final Integer value = map.get(key);
    // if found, remove the value of this key
    if (value == 1) {
      // or remove this entry
      map.remove(key);
    } else {
      // decrease the value of this key
      map.put(key, value - 1);
    }
  }

  private int getFirst(final TreeMap<Integer, Integer> map) {
    final Map.Entry<Integer, Integer> entry = map.firstEntry();
    final int first = entry.getKey();
    this.reduceOrRemove(map, first);
    return first;
  }

  public boolean isPossibleDivide(final int[] hand, final int W) {
    final TreeMap<Integer, Integer> map = new TreeMap<>();
    for (int h : hand) {
      map.put(h, map.getOrDefault(h, 0) + 1);
    }

    while (!map.isEmpty()) {
      // get the very first key
      final int first = this.getFirst(map);

      for (int i = 1; i < W; ++i) {
        final int current = first + i;
        if (map.isEmpty() || map.getOrDefault(current, 0) == 0) {
          // no such entry at all
          return false;
        }
        this.reduceOrRemove(map, current);
      }
    }
    return true;
  }
}
