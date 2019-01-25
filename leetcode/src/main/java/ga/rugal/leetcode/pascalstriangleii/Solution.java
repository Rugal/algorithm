package ga.rugal.leetcode.pascalstriangleii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle-ii/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public List<Integer> getRow(int rowIndex) {
    if (0 == rowIndex) {
      return Arrays.asList(1);
    }
    if (1 == rowIndex) {
      return Arrays.asList(1, 1);
    }
    final List<Integer> previous = this.getRow(rowIndex - 1);
    final List<Integer> result = new ArrayList<>();
    result.add(1);
    for (int i = 1; i < previous.size(); ++i) {
      result.add(previous.get(i - 1) + previous.get(i));
    }
    result.add(1);
    return result;
  }
}
