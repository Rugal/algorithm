package ga.rugal.lintcode.reverse3digitinteger;

/**
 * https://www.lintcode.com/problem/reverse-3-digit-integer/description
 *
 * @author Rugal Bernstein
 */
public class Solution {

  /**
   * @param number: A 3-digit number.
   *
   * @return
   *
   * @return: Reversed number.
   */
  public int reverseInteger(int number) {
    // write your code here
    return (number % 10) * 100 + (number / 10 % 10) * 10 + (number / 100);
  }
}
