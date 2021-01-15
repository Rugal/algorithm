package ga.rugal.amazon.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/
 *
 * @author rugal
 */
public class Solution {

  private final List<List<Integer>> result = new ArrayList<>();

  private int[] numbers;

  public List<List<Integer>> permute(final int[] nums) {
    this.numbers = nums;
    this.result.clear();
    this.backtrack(new ArrayList<>(), new boolean[nums.length]);
    return this.result;
  }

  private void backtrack(final List<Integer> list, boolean[] visited) {
    if (list.size() >= this.numbers.length) {
      this.result.add(new ArrayList<>(list));
      return;
    }
    for (int i = 0; i < this.numbers.length; ++i) {
      if (visited[i]) {
        continue;
      }
      list.add(this.numbers[i]);
      visited[i] = true;
      this.backtrack(list, visited);
      list.remove(list.size() - 1);
      visited[i] = false;
    }
  }
}
