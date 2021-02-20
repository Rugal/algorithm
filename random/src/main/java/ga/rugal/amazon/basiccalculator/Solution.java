package ga.rugal.amazon.basiccalculator;

import java.util.Stack;

/**
 * https://leetcode.com/problems/basic-calculator
 */
public class Solution {
  public int calculate(String s) {

    final Stack<Integer> stack = new Stack<>();
    int operand = 0;
    int result = 0; // For the on-going result
    int sign = 1;  // 1 means positive, -1 means negative

    for (int i = 0; i < s.length(); i++) {

      char ch = s.charAt(i);
      if (Character.isDigit(ch)) {

        // Forming operand, since it could be more than one digit
        operand = 10 * operand + (int) (ch - '0');

      } else if (ch == '+') {

        // Evaluate the expression to the left,
        // with result, sign, operand
        result += sign * operand;

        // Save the recently encountered '+' sign
        sign = 1;

        // Reset operand
        operand = 0;

      } else if (ch == '-') {

        result += sign * operand;
        sign = -1;
        operand = 0;

      } else if (ch == '(') {

        // Push the result and sign on to the stack, for later
        // We push the result first, then sign
        stack.push(result);
        stack.push(sign);

        // Reset operand and result, as if new evaluation begins for the new sub-expression
        sign = 1;
        result = 0;

      } else if (ch == ')') {

        // Evaluate the expression to the left
        // with result, sign and operand
        result += sign * operand;

        // ')' marks end of expression within a set of parenthesis
        // Its result is multiplied with sign on top of stack
        // as stack.pop() is the sign before the parenthesis
        result *= stack.pop();

        // Then add to the next operand on the top.
        // as stack.pop() is the result calculated before this parenthesis
        // (operand on stack) + (sign on stack * (result from parenthesis))
        result += stack.pop();

        // Reset the operand
        operand = 0;
      }
    }
    return result + (sign * operand);
  }
}
