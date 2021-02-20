package ga.rugal.amazon.basiccalculatorii;

import java.util.Stack;

/**
 * https://leetcode.com/problems/basic-calculator-ii/
 *
 * @author rugal
 */
public class Solution {
  public int calculate(String s) {
    if (s == null || s.isEmpty()) return 0;
    final Stack<Integer> stack = new Stack<>();
    int currentNumber = 0;
    char operation = '+';
    for (int i = 0; i < s.length(); i++) {
      char currentChar = s.charAt(i);
      if (Character.isDigit(currentChar)) {
        currentNumber = (currentNumber * 10) + (currentChar - '0');
      }
      // if it is an operator, it's the very last character
      if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar)
            || i == s.length() - 1) {
        if (operation == '-') {
          stack.push(-currentNumber);
        } else if (operation == '+') {
          stack.push(currentNumber);
        } else if (operation == '*') {
          stack.push(stack.pop() * currentNumber);
        } else if (operation == '/') {
          stack.push(stack.pop() / currentNumber);
        }
        operation = currentChar;
        currentNumber = 0;
      }
    }
    int result = 0;
    while (!stack.isEmpty()) {
      result += stack.pop();
    }
    return result;
  }
}
