package ga.rugal.amazon.lrucache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/lru-cache/
 *
 * @author Rugal Bernstein
 */
public class LRUCache {

  private final int capacity;

  private final Map<Integer, Integer> map;

  public LRUCache(final int capacity) {
    this.capacity = capacity;
    map = new LinkedHashMap<>();
  }

  public int get(final int key) {
    final Integer val = map.get(key);
    if (val == null) {
      return -1;
    }
    // remove and put, this is to move this data to the head
    map.remove(key);
    map.put(key, val);
    return val;
  }

  public void put(final int key, final int value) {
    map.remove(key);
    map.put(key, value);
    if (map.size() > this.capacity) {
      final Integer k = map.keySet().iterator().next();
      map.remove(k);
    }
  }
}
