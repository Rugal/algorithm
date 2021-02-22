package ga.rugal.lintcode.numberofairplanesinthesky;

import java.util.ArrayList;
import java.util.List;

import ga.rugal.lintcode.Interval;

public class Solution {

  /**
   * @param airplanes: An interval array
   *
   * @return Count of airplanes are in the sky.
   */
  public int countOfAirplanes(final List<Interval> airplanes) {
    final List<int[]> operations = new ArrayList<>(airplanes.size() * 2);
    for (Interval airplane : airplanes) {
      operations.add(new int[]{airplane.start, 1});
      operations.add(new int[]{airplane.end, -1});
    }

    operations.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

    int max = 0;
    int result = 0;
    for (int[] operation : operations) {
      result += operation[1];
      max = Math.max(max, result);
    }

    return max;
  }
}
