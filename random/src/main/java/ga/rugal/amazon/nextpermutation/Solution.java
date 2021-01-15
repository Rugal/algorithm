package ga.rugal.amazon.nextpermutation;

/**
 * https://leetcode.com/problems/next-permutation/
 *
 * @author rugal
 */
public class Solution {

  /**
   * To find next permutation, the easiest way is:<BR>
   * 1. Find first decreasing number x from backward order<BR>
   * 2. Start from there, find the first number that is "just" bigger than x<BR>
   * 3. Swap them<BR>
   * 4. Reverse numbers after x
   *
   * @param nums
   */
  public void nextPermutation(final int[] nums) {
    int x = nums.length - 2;
    // 1. Find first decreasing number x from backward order
    for (; x >= 0 && nums[x] >= nums[x + 1]; --x);
    if (x >= 0) {
      // 2. Start from this number to the right, find a number that is just bigger than it
      int y = nums.length - 1;
      for (; y >= 0 && nums[x] >= nums[y]; --y);
      this.swap(nums, x, y);
    }
    this.reverse(nums, x + 1);
  }

  private void reverse(int[] nums, int start) {
    int i = start, j = nums.length - 1;
    while (i < j) {
      this.swap(nums, i, j);
      i++;
      j--;
    }
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
