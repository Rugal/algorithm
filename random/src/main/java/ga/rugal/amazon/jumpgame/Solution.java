package ga.rugal.amazon.jumpgame;

/**
 * https://leetcode.com/problems/jump-game/
 *
 * 1. Start with the recursive backtracking solution<BR>
 * 2. Optimize by using a memoization table (top-down dynamic programming)<BR>
 * 3. Remove the need for recursion (bottom-up dynamic programming)<BR>
 * 4. Apply final tricks to reduce the time / memory complexity
 *
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public boolean canJump(final int[] nums) {
    int current = nums.length - 1;
    for (int i = nums.length - 2; i >= 0; i--) {
      if (i + nums[i] >= current) {
        current = i;
      }
    }
    return current == 0;
  }
}
