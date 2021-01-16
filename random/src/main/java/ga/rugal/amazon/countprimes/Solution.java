package ga.rugal.amazon.countprimes;

/**
 * https://leetcode.com/problems/count-primes/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public int countPrimes(int n) {
    final boolean[] composite = new boolean[n + 1];
    for (int i = 2; i <= n; ++i) {
      // find next avilable number(which is definitely a prime)
      for (; i <= n && composite[i]; ++i);
      // set them as composite
      for (int j = 2; i * j <= n; composite[i * j] = true, ++j);
    }
    int count = 0;
    for (int i = 2; i < n; ++i) {
      if (!composite[i]) {
        ++count;
      }
    }
    return count;
  }
}
