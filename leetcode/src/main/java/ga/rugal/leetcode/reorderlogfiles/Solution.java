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
package ga.rugal.leetcode.reorderlogfiles;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/reorder-log-files/
 *
 * @author rugal
 */
public class Solution {

  /**
   * 1. Letter-logs come before digit-logs;<BR>
   * 2. Letter-logs are sorted alphanumerically, by content then identifier;<BR>
   * 3. Digit-logs remain in the same order.
   *
   *
   * @param logs
   *
   * @return
   */
  public String[] reorderLogFiles(final String[] logs) {
    Arrays.sort(logs, (a, b) -> {
                final String[] sa = a.split(" ", 2);
                final String[] sb = b.split(" ", 2);
                final boolean d1 = Character.isDigit(sa[1].charAt(0));
                final boolean d2 = Character.isDigit(sb[1].charAt(0));
                if (!d1 && !d2) {
                  final int c = sa[1].compareTo(sb[1]);
                  if (0 != c) {
                    return c;
                  }
                  return sa[0].compareTo(sb[1]);
                }
                return d1 ? (d2 ? 0 : 1) : -1;
              });
    return logs;
  }
}
