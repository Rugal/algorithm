package ga.rugal.amazon.robotboundedincircle;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/robot-bounded-in-circle/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  private final static int[][] DIRECTION = new int[][]{
    new int[]{0, 1},
    new int[]{1, 0},
    new int[]{0, -1},
    new int[]{-1, 0}
  };

  /**
   * Turn the head by orientation.
   *
   * @param current     the current heading
   * @param orientation the direction turn to
   *
   * @return
   */
  private int turn(final int current, final char orientation) {
    /*
     * 0 N
     * 1 E
     * 2 S
     * 3 W
     */
    return (4 + current + (orientation == 'L' ? -1 : 1)) % 4;
  }

  private int[] move(final int[] current, int direction) {
    current[0] += DIRECTION[direction][0];
    current[1] += DIRECTION[direction][1];
    return current;
  }

  public boolean isRobotBounded(final String instructions) {
    int direction = 0;
    final int[] vector = new int[2];
    for (var c : instructions.toCharArray()) {
      if ('G' == c) {
        this.move(vector, direction);
      } else {
        direction = this.turn(direction, c);
      }
    }

    return direction != 0 || Arrays.equals(vector, new int[]{0, 0});
  }
}
