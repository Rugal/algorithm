package ga.rugal.wish.differentwaystoaddparentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/different-ways-to-add-parentheses/
 *
 * @author Rugal Bernstein
 */
class Solution {

  public List<Integer> diffWaysToCompute(String expression) {

    List[][] memo = new List[expression.length() + 1][expression.length() + 1];
    return ways(expression, 0, expression.length(), memo);

  }

  private List<Integer> ways(String expression, int start, int end, List[][] memo) {

    if (memo[start][end] != null) {
      return memo[start][end];
    }

    List<Integer> res = new ArrayList<>();

    for (int i = start; i < end; i++) {
      char curr = expression.charAt(i);

      if (curr != '+' && curr != '-' && curr != '*') {
        continue;
      }

      List<Integer> leftVals = ways(expression, start, i, memo);
      List<Integer> rightVals = ways(expression, i + 1, end, memo);

      for (int leftVal : leftVals) {
        for (int rightVal : rightVals) {

          if (curr == '+') {
            //System.out.println(expression.substring(0,i) + " + " + expression.substring(i+1));
            res.add(leftVal + rightVal);
          }
          if (curr == '-') {
            // System.out.println(expression.substring(0,i) + " - " + expression.substring(i+1));
            res.add(leftVal - rightVal);
          }
          if (curr == '*') {
            // System.out.println(expression.substring(0,i) + " * " + expression.substring(i+1));
            res.add(leftVal * rightVal);
          }
        }
      }

    }

    // integer
    if (res.size() == 0) {
      res.add(Integer.valueOf(expression.substring(start, end)));
    }

    memo[start][end] = res;
    return res;
  }
}
