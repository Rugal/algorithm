package ga.rugal.leetcode.singleelementinasortedarray;

/**
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public int singleNonDuplicate(int[] nums) {
    int result = 0;
    for (int n : nums) {
      result ^= n;
    }
    return result;
  }
}
