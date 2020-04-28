package ga.rugal.leetcode.firstuniquenumber;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3313/
 *
 * @author rugal
 */
public class FirstUnique {

  private final Set<Integer> duplicated = new HashSet<>();

  private final Set<Integer> unique = new HashSet<>();

  private final Deque<Integer> queue = new LinkedList<>();

  public FirstUnique(int[] nums) {
    for (int n : nums) {
      this.add(n);
    }
  }

  public int showFirstUnique() {
    return this.queue.isEmpty() ? -1 : this.queue.getFirst();
  }

  public void add(int value) {
    // ignore duplicated value at all
    if (this.duplicated.contains(value)) {
      return;
    }
    // if we have this unique value already, means it is not unique anymore
    if (this.unique.contains(value)) {
      this.unique.remove(value);
      this.duplicated.add(value);
      this.queue.remove(value);
      return;
    }
    // if not seem it at all
    this.queue.add(value);
    this.unique.add(value);
  }
}
