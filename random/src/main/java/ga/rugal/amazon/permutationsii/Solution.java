package ga.rugal.amazon.permutationsii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations-ii
 *
 * @author rugal
 */
public class Solution {

  private List<List<Integer>> result;

  private int[] numbers;

  public List<List<Integer>> permuteUnique(int[] input) {
    this.numbers = input;
    this.result = new ArrayList<>();
    if (this.numbers == null || this.numbers.length == 0) {
      return result;
    }
    boolean[] used = new boolean[this.numbers.length];
    // sort number so as to avoid duplication
    Arrays.sort(this.numbers);
    this.dfs(used, new ArrayList<>());
    return result;
  }

  private void dfs(final boolean[] used, final List<Integer> list) {
    if (list.size() == numbers.length) {
      result.add(new ArrayList<>(list));
      return;
    }
    for (int i = 0; i < numbers.length; i++) {
      if (used[i]
          //same as duplicated subset, this is to skip duplication
          // if same as last number && the previous number is used already
          || (i > 0 && numbers[i - 1] == numbers[i] && !used[i - 1])) {
        continue;
      }
      used[i] = true;//prevent the same index from being used again
      list.add(numbers[i]);
      this.dfs(used, list);
      used[i] = false;
      list.remove(list.size() - 1);
    }
  }
}
