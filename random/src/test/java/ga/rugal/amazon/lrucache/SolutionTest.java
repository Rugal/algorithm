package ga.rugal.amazon.lrucache;

import org.junit.jupiter.api.Test;

public class SolutionTest {
  
  @Test
  public void test() {
    final LRUCache cache = new LRUCache(2);
    cache.put(1, 1);
    cache.put(2, 2);
    cache.get(1);
    cache.put(3, 3);
    cache.get(2);
    cache.put(4, 4);
    cache.get(1);
    cache.get(3);
    cache.get(4);
  }
}
