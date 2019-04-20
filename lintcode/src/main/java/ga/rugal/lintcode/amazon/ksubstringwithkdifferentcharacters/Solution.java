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
package ga.rugal.lintcode.amazon.ksubstringwithkdifferentcharacters;

import java.util.HashSet;

/**
 * https://www.lintcode.com/problem/k-substring-with-k-different-characters
 *
 * @author rugal
 */
public class Solution {

  private int get(final char c) {
    return c - 'A';
  }

  /**
   * @param stringIn: The original string.
   * @param K:        The length of substrings.
   *
   * @return return the count of substring of length K and exactly K distinct characters.
   */
  public int KSubstring(final String stringIn, final int K) {
    final int[] map = new int[this.get('z') + 1];
    final HashSet<String> s = new HashSet<>();
    int count = 0;
    for (int i = 0; i < K && i < stringIn.length(); i++) {
      if (map[this.get(stringIn.charAt(i))] == 0) {
        //count number of unique character in first k characters
        count++;
      }
      ++map[this.get(stringIn.charAt(i))];
    }
    if (count == K) {
      s.add(stringIn.substring(0, K));
    }
    for (int i = K; i < stringIn.length(); i++) {
      //remove the very first character
      --map[this.get(stringIn.charAt(i - K))];
      if (map[this.get(stringIn.charAt(i - K))] == 0) {
        count--;
      }
      //add the current character
      if (map[this.get(stringIn.charAt(i))] == 0) {
        count++;
      }
      map[this.get(stringIn.charAt(i))]++;

      //add it if there are K number of unique characters
      if (count == K) {
        s.add(stringIn.substring(i - K + 1, i + 1));
      }
    }
    return s.size();
  }
}
