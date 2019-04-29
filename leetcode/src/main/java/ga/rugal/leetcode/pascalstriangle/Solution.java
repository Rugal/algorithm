package ga.rugal.leetcode.pascalstriangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle-ii/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public List<List<Integer>> generate(final int numRows) {
    final List<List<Integer>> result = new ArrayList<>();
    if (numRows == 0) {
      return result;
    }
    result.add(Arrays.asList(1));
    if (numRows == 1) {
      return result;
    }
    result.add(Arrays.asList(1, 1));
    if (numRows == 2) {
      return result;
    }
    for (int i = 3; i <= numRows; ++i) {
      final List<Integer> previous = result.get(result.size() - 1);

      final List<Integer> temp = new ArrayList<>();
      temp.add(1);//the 1 at left
      for (int j = 1; j < previous.size(); ++j) {
        temp.add(previous.get(j - 1) + previous.get(j));
      }
      temp.add(1);//the 1 at right
      result.add(temp);
    }

    return result;
  }
}
