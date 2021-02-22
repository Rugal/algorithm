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
package ga.rugal.amazon.meetingroomsii;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/meeting-rooms-ii/
 *
 * @author rugal
 */
public class Solution {

  public int minMeetingRooms(int[][] intervals) {

    // Check for the base case. If there are no intervals, return 0
    if (intervals.length == 0) {
      return 0;
    }

    // Min heap
    final PriorityQueue<Integer> allocator = new PriorityQueue<>(intervals.length, (a, b) -> a - b);

    // Sort the intervals by start time
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

    // Add the first meeting, record the end time of meeting
    allocator.add(intervals[0][1]);

    // Iterate over remaining intervals
    for (int i = 1; i < intervals.length; i++) {
      // keep checking if the top meeting room is freed. If not, we have to push the current one into heap
      // If the room due to free up the earliest is free, assign that room to this meeting.
      if (intervals[i][0] >= allocator.peek()) {
        // if new meeting starts after the the earliest meeting ends
        // the earliest meeting will not block any one after this meeting anymore
        allocator.poll();
      }

      // If a new room is to be assigned, then also we add to the heap,
      // If an old room is allocated, then also we have to add to the heap with updated end time.
      allocator.add(intervals[i][1]);
    }

    // The size of the heap tells us the minimum rooms required for all the meetings.
    return allocator.size();
  }
}
