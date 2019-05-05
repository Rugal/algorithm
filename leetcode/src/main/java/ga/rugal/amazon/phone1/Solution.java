package ga.rugal.amazon.phone1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Rugal Bernstein
 */
public class Solution {

  private Map<Character, Set<Integer>> map;

  private String text;

  private boolean flag = false;

  /**
   * Q: You have a collection of 'baby blocks' (cubes with single upper-case letters of the alphabet
   * on each side). Each block could have up to six different letters on it (or even more if we're
   * in a universe with more than 3 dimensions), but for the sake of simplicity, we'll assume for
   * now that each block only has two distinct letters.
   *
   * The problem is to write a function that takes a collection of blocks and a target word and
   * returns true or false depending on whether or not you can spell the target word with the
   * collection of blocks.
   *
   * Example: (B,A),(A,B),(B,Y),(T,H), (A,B): "BABY" => yes<BR>
   * (B,A),(A,B),(L,E),(A,B): "ABLE" => no (since L and E are on the same block). "BAD"
   *
   * @param input, each coin just use once B, A A, B X, Y A, B
   *
   * @param target BABY
   *
   * @return
   */
  public boolean coinGame(final char[][] input, final String target) {
    this.text = target;
    this.map = this.build(input);
    this.backtrack(0, new HashSet<>());
    return this.flag;
  }

  private Map<Character, Set<Integer>> build(final char[][] input) {
    final Map<Character, Set<Integer>> m = new HashMap<>();
    for (int i = 0; i < input.length; ++i) {
      for (char c : input[i]) {
        final Set<Integer> set = m.getOrDefault(c, new HashSet<>());
        set.add(i);
        m.put(c, set);
      }
    }
    return m;
  }

  private void backtrack(final int current, final Set<Integer> visited) {
    if (this.flag || current >= this.text.length()) {
      this.flag = true;
      return;
    }

    final Set<Integer> set = this.map.getOrDefault(this.text.charAt(current), new HashSet<>());
    if (set.isEmpty()) {
      return;
    }
    for (int i : set) {
      if (this.flag) {
        return;
      }
      if (!visited.contains(i)) {
        final Set<Integer> nextVisited = new HashSet<>(visited);
        nextVisited.add(i);
        this.backtrack(current + 1, nextVisited);
      }
    }
  }

// [T, H] -> A
}
