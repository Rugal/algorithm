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

  private int[] numbers;

  public List<List<Integer>> subsets(final int[] nums) {
    this.numbers = nums;
    this.result.clear();
    if (nums == null || nums.length == 0) {
      return this.result;
    }

    this.make(new ArrayList<>(), 0);
    return this.result;
  }

  private void make(final List<Integer> list, final int position) {
    //Here each state is unique, hence we add them to result
    this.result.add(new ArrayList<>(list));
    for (int i = position; i < this.numbers.length; i++) {
      list.add(this.numbers[i]);
      this.make(list, i + 1);
      list.remove(list.size() - 1);
    }
  }
}
