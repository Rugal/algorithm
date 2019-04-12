package ga.rugal.leetcode.graycode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/gray-code/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public List<Integer> grayCode(int n) {
    List<Integer> res = new ArrayList<>();
    //base value
    res.add(0);

    for (int i = 1; i <= n; i++) {
      int size = res.size(), base = 1 << (i - 1);
      //In previous round, we have 00 and 01
      //In current round, we add one more bit
      //We basically add the bit by the reverse order of previous list

      //example: we have 00 and 01
      //add one bit to 01 then, to 00
      //and we have 11 and 10
      //in totaly we have 00, 01, 11, 10
      for (int j = size - 1; j >= 0; j--) {
        res.add(base + res.get(j));
      }
    }
    return res;
  }
}
