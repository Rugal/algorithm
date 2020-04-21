package ga.rugal.leetcode.leftmostcolumnwithatleastaone;

import java.util.List;

/**
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3306/
 *
 * @author rugal
 */
public class Solution {

  public int leftMostColumnWithOne(final BinaryMatrix bm) {
    int row = 0, column = bm.dimensions().get(1) - 1;
    boolean rowHas1 = false, overallHas1 = false;

    while (column >= 0 && row < bm.dimensions().get(0)) {
      if (1 == bm.get(row, column)) {
        --column;
        rowHas1 = true;
        overallHas1 = true;
        continue;
      }
      if (rowHas1) {
        rowHas1 = false;
        ++column;
      }
      ++row;
    }

    return overallHas1
           // column = -1 so it reaches the very left
           // otherwise will be deviated back automatically
           ? (column < 0 ? 0 : column)
           : -1;
  }
}

interface BinaryMatrix {

  int get(int x, int y);

  List<Integer> dimensions();
}
