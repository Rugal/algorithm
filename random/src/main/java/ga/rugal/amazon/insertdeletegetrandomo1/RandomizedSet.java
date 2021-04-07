package ga.rugal.amazon.insertdeletegetrandomo1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1/
 *
 * @author Rugal Bernstein
 */
public class RandomizedSet {

  private final Map<Integer, Integer> map = new HashMap<>();

  private final List<Integer> list = new ArrayList<>();

  private final Random random = new Random();

  /**
   * Initialize your data structure here.
   */
  public RandomizedSet() {
  }

  /**
   * Inserts a value to the set. Returns true if the set did not already contain the specified
   * element.
   */
  public boolean insert(int val) {
    if (!this.map.containsKey(val)) {
      this.map.put(val, this.list.size());
      this.list.add(val);
      return true;
    }
    return false;
  }

  /**
   * Removes a value from the set. Returns true if the set contained the specified element.
   */
  public boolean remove(int val) {
    if (this.map.containsKey(val)) {
      final int lastKey = this.list.get(this.list.size() - 1);
      final int index = this.map.get(val);
      Collections.swap(this.list, index, this.list.size() - 1);
      this.list.remove(this.list.size() - 1);
      this.map.put(lastKey, index);
      this.map.remove(val);
      return true;
    }
    return false;
  }

  /**
   * Get a random element from the set.
   */
  public int getRandom() {
    return this.list.get(this.random.nextInt(this.list.size()));
  }
}
