package ga.rugal.amazon.jumpgameii;

/**
 * https://leetcode.com/problems/jump-game-ii/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public int jump(final int[] nums) {
    return this.jump_greedy(nums);
  }

  public int jump_dp(final int[] nums) {
    final var step = new int[nums.length];
    for (int i = 0; i < nums.length; ++i) {
      step[i] = Integer.MAX_VALUE;
    }
    step[0] = 0;
    for (int i = 0; i < nums.length; ++i) {
      for (int j = 1; j <= nums[i] && i + j < nums.length; ++j) {
        step[i + j] = Math.min(step[i + j], step[i] + 1);
      }
    }
    return step[nums.length - 1];
  }

  public int jump_greedy(int[] nums) {
    int jumps = 0, currentJumpEnd = 0, farthest = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      // we continuously find the how far we can reach in the current jump
      farthest = Math.max(farthest, i + nums[i]);
      // if we have come to the end of the current jump,
      // we need to make another jump
      if (i == currentJumpEnd) {
        jumps++;
        currentJumpEnd = farthest;
      }
    }
    return jumps;
  }
}
