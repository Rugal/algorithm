package ga.rugal.leetcode.removeduplicatesfromsortedarray;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public int removeDuplicates(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int index = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[index] != nums[i]) {
        nums[++index] = nums[i];
      }
    }
    return 0;
  }
}
