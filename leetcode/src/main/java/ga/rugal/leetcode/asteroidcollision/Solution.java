package ga.rugal.leetcode.asteroidcollision;

import java.util.Stack;

/**
 * https://leetcode.com/problems/asteroid-collision/
 *
 * @author rugal
 */
public class Solution {

  public int[] asteroidCollision(final int[] asteroids) {
    final Stack<Integer> stack = new Stack<>();
    for (int a : asteroids) {
      boolean push = true;
      while (!stack.isEmpty()) {
        final int top = stack.peek();
        if (top * a > 0 || top < 0) {
          break;
        }
        if (top >= Math.abs(a)) {
          push = false;
          if (top == Math.abs(a)) {
            stack.pop();
          }
          break;
        }
        stack.pop();
      }
      if (push) {
        stack.push(a);
      }
    }

    return stack.stream()
      .mapToInt(Integer::intValue)
      .toArray();
  }
}
