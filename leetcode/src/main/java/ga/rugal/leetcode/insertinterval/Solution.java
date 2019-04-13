/*
 * Copyright 2019 rugal.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ga.rugal.leetcode.insertinterval;

import java.util.LinkedList;
import java.util.List;

import ga.rugal.leetcode.Interval;

/**
 * https://leetcode.com/problems/insert-interval/
 *
 * @author rugal
 */
public class Solution {

  public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    final int size = intervals.size();
    for (int i = 0; i < intervals.size(); ++i) {
      if (intervals.get(i).start >= newInterval.start) {
        //insert into a suitable position
        intervals.add(i, newInterval);
        break;
      }
    }
    if (size == intervals.size()) {
      intervals.add(newInterval);
    }
    final LinkedList<Interval> merged = new LinkedList<>();
    for (final Interval interval : intervals) {
      if (merged.isEmpty() || merged.getLast().end < interval.start) {
        // new interval
        merged.add(interval);
      } else {
        // otherwise, there is overlap, so we merge the current and previous intervals.
        merged.getLast().end = Math.max(merged.getLast().end, interval.end);
      }
    }
    return merged;
  }
}
