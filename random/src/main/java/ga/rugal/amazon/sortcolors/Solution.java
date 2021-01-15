package ga.rugal.amazon.sortcolors;

/**
 * https://leetcode.com/problems/sort-colors/
 *
 * @author rugal
 */
public class Solution {

  public void sortColors(final int[] nums) {
    int one = 0, zero = 0;
    for (int i = 0; i < nums.length; ++i) {
      final int value = nums[i];
      nums[i] = 2;
      if (value < 2) {
        // count 0 and 1
        nums[one++] = 1;
      }
      if (value == 0) {
        // count 0
        nums[zero++] = 0;
      }
    }
  }
}
