package ga.rugal.lintcode.meetingroomsii;

import java.util.ArrayList;
import java.util.List;

import ga.rugal.lintcode.Interval;

/**
 * https://www.lintcode.com/problem/meeting-rooms-ii/description
 *
 * @author Rugal Bernstein
 */
public class Solution {

  /**
   * @param intervals: an array of meeting time intervals
   *
   * @return: the minimum number of conference rooms required
   */
  public int minMeetingRooms(final List<Interval> intervals) {
    final List<Integer[]> list = new ArrayList<>();
    for (Interval i : intervals) {
      list.add(new Integer[]{i.start, 1});
      list.add(new Integer[]{i.end, -1});
    }
    list.sort((a, b) -> a[0] == b[0] // if times are same
                        ? a[1] - b[1] // order by end -> start
                        : a[0] - b[0]); // otherwise sort by time itself
    int max = 0, count = 0;
    for (Integer[] pair : list) {
      count += pair[1];
      max = Math.max(max, count);
    }
    return max;
  }
}
