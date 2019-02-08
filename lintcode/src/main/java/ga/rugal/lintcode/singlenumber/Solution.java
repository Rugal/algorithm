package ga.rugal.lintcode.singlenumber;

/**
 * https://www.lintcode.com/problem/single-number/description
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public int singleNumber(int[] A) {
    if (A == null || A.length == 0) {
      return -1;
    }
    int sum = 0;
    for (int i = 0; i < A.length; i++) {
      //XOR will cancel the same number
      sum ^= A[i];
    }
    //the last one is the the single number
    return sum;
  }
}
