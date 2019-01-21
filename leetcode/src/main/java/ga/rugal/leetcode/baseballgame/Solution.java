package ga.rugal.leetcode.baseballgame;

import java.util.Stack;

/**
 * https://leetcode.com/problems/baseball-game/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  /**
   * Integer: score<BR>
   * +: Last 2 valid score<BR>
   * C: Invalidate last score<BR>
   * D: Double last score
   *
   * @param ops
   *
   * @return
   */
  public int calPoints(String[] ops) {
    Stack<Integer> stack = new Stack<>();
    int sum = 0;
    for (String op : ops) {
      int number = 0;
      switch (op) {
        case "+":
          number = stack.get(stack.size() - 1) + stack.get(stack.size() - 2);
          stack.push(number);
          break;
        case "C":
          number = -1 * stack.pop();
          break;
        case "D":
          number = stack.peek() * 2;
          stack.push(number);
          break;
        default:
          number = Integer.parseInt(op);
          stack.push(number);
      }
      sum += number;
    }
    return sum;
  }
}
