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
package ga.rugal.leetcode.mergeintervals;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import ga.rugal.leetcode.Interval;

/**
 * https://leetcode.com/problems/merge-intervals/
 *
 * @author rugal
 */
public class Solution {

  private class IntervalComparator implements Comparator<Interval> {

    @Override
    public int compare(Interval a, Interval b) {
      return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
    }
  }

  public List<Interval> merge(List<Interval> intervals) {
    Collections.sort(intervals, new IntervalComparator());

    final LinkedList<Interval> merged = new LinkedList<>();
    for (final Interval interval : intervals) {
      // if the list of merged intervals is empty or if the current
      // interval does not overlap with the previous, simply append it.
      if (merged.isEmpty() || merged.getLast().end < interval.start) {
        merged.add(interval);
      } // otherwise, there is overlap, so we merge the current and previous intervals.
      else {
        merged.getLast().end = Math.max(merged.getLast().end, interval.end);
      }
    }

    return merged;
  }
}
