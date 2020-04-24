package ga.rugal.leetcode.bitwiseandofnumbersrange;

/**
 * https://leetcode.com/problems/bitwise-and-of-numbers-range/
 *
 * @author rugal
 */
public class Solution {

  /**
   * https://leetcode.com/problems/bitwise-and-of-numbers-range/discuss/593403/Bit-masks-no-loops
   *
   * @param m left
   * @param n right
   *
   * @return
   */
  public int rangeBitwiseAnd(final int m, final int n) {
    //1. n - m is the difference between m and n
    //2. this different will go through m to 2(without hesitation)
    //3. most importantly it will flip every bit to go through
    //4. for each bit it flips, 0 will be kept
    //5. so the simplest way is to calculate the highest bit of difference
    //6. then flip all bits beneth it
    //7. use a = (int)log2(n - m) to calculate the high bit of this number, e.g.  2
    //8. then a + 1 to get the highest bit that covers all bit that will go through, e.g. 3
    //which means 0,1,2 have to flip
    //9. then do bit shift to the left to get the actual value, e.g. 1<<3 = 1000
    //10. then minus 1 to get the mask, e.g. 8 - 1 = 7 = 111(smart)
    //11. then do the compliment to get mask for entire byte data, e.g. 11111000(smart)
    //12. last step is to bit AND all the value
    return m == n
           ? m
           : m & n //12
             & ~((1 //9, 11
                  << (1 //8
                      + ((int) (Math.log(n - m) / Math.log(2))))) //7
                 - 1); // 10
  }
}
