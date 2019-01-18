package ga.rugal.leetcode.subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  private final List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> subsets(int[] nums) {
    this.result.clear();
    if (nums == null || nums.length == 0) {
      return this.result;
    }

    this.make(new ArrayList<>(), nums, 0);
    return this.result;
  }

  private void make(List<Integer> list, int[] nums, int position) {
    this.result.add(new ArrayList<>(list));
    for (int i = position; i < nums.length; i++) {
      list.add(nums[i]);
      this.make(list, nums, i + 1);
      list.remove(list.size() - 1);
    }
  }
}
