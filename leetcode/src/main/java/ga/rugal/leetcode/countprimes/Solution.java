package ga.rugal.leetcode.countprimes;

/**
 * https://leetcode.com/problems/count-primes/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public int countPrimes(int n) {
    final boolean[] array = new boolean[n + 1];
    for (int i = 2; i < n; ++i) {
      for (; i < n + 1 && array[i]; ++i);
      for (int j = 2; i * j < n; ++j) {
        array[i * j] = true;
      }
    }

    int count = 0;
    for (int i = 2; i < n; ++i) {
      if (!array[i]) {
        count++;
      }
    }
    return count;
  }
}
