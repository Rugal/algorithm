package ga.rugal.leetcode.twosumiiinputarrayissorted;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public int[] twoSum(int[] numbers, int target) {
    for (int left = 0, right = numbers.length - 1; left < right;) {
      final int value = numbers[left] + numbers[right];
      if (value == target) {
        return new int[]{left + 1, right + 1};
      }
      if (value < target) {
        left++;
      } else {
        right--;
      }
    }
    return null;
  }
}
