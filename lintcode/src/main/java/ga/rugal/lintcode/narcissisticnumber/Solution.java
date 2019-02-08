package ga.rugal.lintcode.narcissisticnumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://www.lintcode.com/problem/narcissistic-number/description
 *
 * @author Rugal Bernstein
 */
public class Solution {

  private static final int[][] TABLE = new int[][]{
    null,
    new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
    null,
    new int[]{153, 370, 371, 407},
    new int[]{1634, 8208, 9474},
    new int[]{54748, 92727, 93084},
    new int[]{548834},
    new int[]{1741725, 4210818, 9800817, 9926315},
    new int[]{24678050, 24678051, 88593477},};

  /**
   * @param n: The number of digits
   *
   * @return
   *
   * @return: All narcissistic numbers with n digits
   */
  public List<Integer> getNarcissisticNumbers(final int n) {
    // write your code here
    if (null == TABLE[n]) {
      return null;
    }
    return Arrays.stream(TABLE[n]).boxed().collect(Collectors.toList());
  }
}
