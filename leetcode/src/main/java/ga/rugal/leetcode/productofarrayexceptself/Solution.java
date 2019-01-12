package ga.rugal.leetcode.productofarrayexceptself;

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public int[] productExceptSelf(final int[] nums) {
    int[] res = new int[nums.length];
    res[0] = 1;
    //multiply numbers before the item
    for (int i = 1; i < nums.length; i++) {
      res[i] = res[i - 1] * nums[i - 1];
    }
    //then multiply numbers after the item
    int right = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      res[i] *= right;
      right *= nums[i];
    }
    return res;
  }
}
