package ga.rugal.amazon.searchinrotatedsortedarrayii;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 *
 * @author rugal
 */
public class Solution {

  public boolean search(final int[] nums, final int target) {
    // note here end is initialized to len instead of (len-1)
    int start = 0, end = nums.length;
    while (start < end) {
      int mid = (start + end) / 2;
      if (nums[mid] == target) {
        return true;
      }
      if (nums[start] < nums[mid]) { // nums[start..mid] is sorted
        // check if target in left half
        if (nums[start] <= target && target < nums[mid]) {
          end = mid;
        } else {
          start = mid + 1;
        }
        continue;
      }
      if (nums[mid] < nums[start]) { // nums[mid..end] is sorted
        // check if target in right half
        if (target > nums[mid] && target < nums[start]) {
          start = mid + 1;
        } else {
          end = mid;
        }
        continue;
      }
      // have no idea about the array, but we can exclude nums[start] because nums[start] == nums[mid]
      start++;
    }
    return false;
  }
}
