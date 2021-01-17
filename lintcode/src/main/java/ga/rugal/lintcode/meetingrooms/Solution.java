package ga.rugal.lintcode.meetingrooms;

import java.util.List;

import ga.rugal.lintcode.Interval;

/**
 * https://www.lintcode.com/problem/meeting-rooms/description
 *
 * @author Rugal Bernstein
 */
public class Solution {

  /**
   * @param intervals: an array of meeting time intervals
   *
   * @return: if a person could attend all meetings
   */
  public boolean canAttendMeetings(final List<Interval> intervals) {
    if (intervals.size() < 2) {
      return true;
    }
    intervals.sort((a, b) -> a.start - b.start);
    for (int i = 1; i < intervals.size(); ++i) {
      if (intervals.get(i - 1).end > intervals.get(i).start) {
        return false;
      }
    }
    return true;
  }
}
