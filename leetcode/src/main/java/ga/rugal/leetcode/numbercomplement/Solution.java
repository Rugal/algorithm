package ga.rugal.leetcode.numbercomplement;

/**
 * https://leetcode.com/problems/number-complement/
 *
 * @author rugal
 */
public class Solution {

  public int findComplement(int num) {
    // full complement
    final int n = ~num;
    int i = 0;
    while (num > 0) {
      num >>= 1;
      i++;
    }
    return ((1 << i) - 1) & n;
  }
}
