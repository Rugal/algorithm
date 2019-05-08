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
package ga.rugal.leetcode.longestwordindictionary;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-word-in-dictionary/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  /**
   * Sort the words alphabetically, therefore shorter words always comes before longer words;<BR>
   * Along the sorted list, populate the words that can be built;<BR>
   * Any prefix of a word must comes before that word.
   *
   * @param words
   *
   * @return
   */
  public String longestWord(final String[] words) {
    Arrays.sort(words);
    //put prefix, short word before
    final Set<String> built = new HashSet<>();
    String res = "";
    for (String w : words) {
      if (w.length() == 1
          || built.contains(w.substring(0, w.length() - 1))) {//if prefix is contained
        res = w.length() > res.length() ? w : res;
        built.add(w);
      }
    }
    return res;
  }
}
