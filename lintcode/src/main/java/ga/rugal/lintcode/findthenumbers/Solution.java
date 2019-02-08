package ga.rugal.lintcode.findthenumbers;

/**
 *
 * @author Rugal Bernstein
 */
public class Solution {

  /**
   * @param A: The A
   * @param B: The B
   *
   * @return Returns the sum of all qualified numbers
   */
  public int getSum(int A, int B) {
    // Write your code here
    int sum = 0;
    int current = A / 3;
    if (current * 3 < A) {
      ++current;
    }
    for (current *= 3; current <= B; current += 3) {
      sum += current;
    }
    return sum;
  }
}
