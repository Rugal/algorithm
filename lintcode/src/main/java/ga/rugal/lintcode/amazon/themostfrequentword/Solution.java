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
package ga.rugal.lintcode.amazon.themostfrequentword;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * https://www.lintcode.com/problem/the-most-frequent-word
 *
 * @author rugal
 */
public class Solution {

  /**
   * @param s:            a string
   * @param excludewords: a dict
   *
   * @return the most frequent word
   */
  public String frequentWord(final String s, final Set<String> excludewords) {
    // Write your code here
    StringBuilder sb = new StringBuilder();
    final Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); ++i) {
      final char c = s.charAt(i);
      if (Character.isAlphabetic(c)) {
        sb.append(c);
        continue;
      }
      if (Character.isSpaceChar(c)) {
        final String t = sb.toString();
        sb = new StringBuilder();
        if (excludewords.contains(t)) {
          continue;
        }
        if (!map.containsKey(t)) {
          map.put(t, 0);
        }
        map.put(t, map.get(t) + 1);
      }
    }
    if (sb.length() != 0 && !excludewords.contains(sb.toString())) {
      final String t = sb.toString();
      if (!map.containsKey(t)) {
        map.put(t, 0);
      }
      map.put(t, map.get(t) + 1);
    }
    int max = -1;
    String result = "";
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      if (max > entry.getValue()) {
        continue;
      }
      if (max < entry.getValue()) {
        max = entry.getValue();
        result = entry.getKey();
        continue;
      }
      if (result.compareTo(entry.getKey()) > 0) {
        result = entry.getKey();
      }
    }

    return result;
  }
}
