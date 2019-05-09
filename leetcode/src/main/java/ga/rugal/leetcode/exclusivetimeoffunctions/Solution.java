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
package ga.rugal.leetcode.exclusivetimeoffunctions;

import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/exclusive-time-of-functions/
 *
 * @author rugal
 */
public class Solution {

  public int[] exclusiveTime(final int n, final List< String> logs) {
    final Stack<Integer> stack = new Stack<>();
    final int[] result = new int[n];
    String[] s = logs.get(0).split(":");
    stack.push(Integer.parseInt(s[0]));
    int previous = Integer.parseInt(s[2]);
    for (int i = 1; i < logs.size(); ++i) {
      s = logs.get(i).split(":");
      final int time = Integer.parseInt(s[2]);
      if (s[1].equals("start")) {
        //start a new function
        if (!stack.isEmpty()) {
          result[stack.peek()] += time - previous;
        }
        stack.push(Integer.parseInt(s[0]));
        previous = time;
      } else {
        //end the current function
        result[stack.peek()] += time - previous + 1;
        stack.pop();
        previous = time + 1;//move to next function, since function will not overlap
      }
    }
    return result;
  }
}
