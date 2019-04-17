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
package ga.rugal.leetcode.wordbreakii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-break-ii/
 *
 * @author rugal
 */
public class Solution {

  private Set<String> set;

  private final Map<String, List<String>> map = new HashMap<>();

  /**
   * To enhance performance, here we use map to cache repeated result.
   *
   * @param s
   * @param wordDict
   *
   * @return
   */
  public List<String> wordBreak(String s, List<String> wordDict) {
    if (s.length() == 0) {
      return new ArrayList<>();
    }

    this.set = new HashSet<>(wordDict);
    return dfs(s);
  }

  /**
   * break the sentence into two part, check whether set contains first part.If so, recursively
   * check the second part
   *
   * @param s
   *
   * @return
   */
  public List<String> dfs(final String s) {
    // get string directly if key is cached
    if (map.containsKey(s)) {
      return map.get(s);
    }

    final List<String> result = new ArrayList<>();
    // base case: the leaf level (represents the last word of sentence)
    if (set.contains(s)) {
      result.add(s);
    }

    // try every possible prefix string, and recursively check suffix string
    for (int i = 1; i < s.length(); i++) {
      final String prefix = s.substring(0, i);
      if (set.contains(prefix)) {
        //after prefix, search the words in rest string
        for (String l : this.dfs(s.substring(i))) {
          result.add(prefix + " " + l);
        }
      }
    }
    // update memo cache
    this.map.put(s, result);
    return result;
  }
}
