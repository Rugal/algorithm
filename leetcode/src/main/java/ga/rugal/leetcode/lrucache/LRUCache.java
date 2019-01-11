package ga.rugal.leetcode.lrucache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/lru-cache/
 *
 * @author Rugal Bernstein
 */
public class LRUCache {

  private final int capacity;

  private final Map<Integer, Integer> map = new LinkedHashMap<>();

  public LRUCache(final int capacity) {
    this.capacity = capacity;
  }

  public int get(final int key) {
    final Integer val = map.get(key);
    if (val == null) {
      return -1;
    }
    map.remove(key);
    map.put(key, val);
    return val;
  }

  public void put(final int key, final int value) {
    map.remove(key);
    map.put(key, value);
    if (map.size() > this.capacity) {
      map.remove(this.map.keySet().iterator().next());
    }
  }
}
