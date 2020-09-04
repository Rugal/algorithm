/*
 * Copyright 2019 rugalbernstein.
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
package ga.rugal.amazon.restoreipaddresses;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/restore-ip-addresses/
 *
 * @author rugalbernstein
 */
public class Solution {

  private int n;

  private String s;

  private final LinkedList<String> segments = new LinkedList<>();

  private final ArrayList<String> output = new ArrayList<>();

  /**
   * Check if the current segment is valid:<BR>
   * 1. less or equal to 255<BR>
   * 2. the first character could be '0' only if the segment is equal to '0'
   */
  private boolean valid(final String segment) {
    final int m = segment.length();
    if (m > 3) {
      return false;
    }
    return (segment.charAt(0) != '0')
           ? (Integer.valueOf(segment) <= 255)
           : (m == 1);
  }

  private void update_output(int curr_pos) {
    /*
     * Append the current list of segments to the list of solutions
     */
    String segment = s.substring(curr_pos + 1, n);
    if (this.valid(segment)) {
      segments.add(segment);
      output.add(String.join(".", segments));
      segments.removeLast();
    }
  }

  /**
   *
   * @param previous the position of the previously placed dot
   * @param dots     number of dots to place
   */
  private void backtrack(final int previous, final int dots) {
    // The current dot curr_pos could be placed
    // in a range from prev_pos + 1 to prev_pos + 4.
    // The dot couldn't be placed
    // after the last character in the string.
    final int max_pos = Math.min(n - 1, previous + 4);
    for (int i = previous + 1; i < max_pos; i++) {
      final String segment = s.substring(previous + 1, i + 1);
      if (this.valid(segment)) {
        this.segments.add(segment);  // place dot
        // if all 3 dots are placed
        if (dots - 1 == 0) {
          this.update_output(i);  // add the solution to output
        } else {
          this.backtrack(i, dots - 1);  // continue to place dots
        }
        this.segments.removeLast();  // remove the last placed dot
      }
    }
  }

  public List<String> restoreIpAddresses(final String s) {
    n = s.length();
    this.s = s;
    this.backtrack(-1, 3);
    return output;
  }
}
