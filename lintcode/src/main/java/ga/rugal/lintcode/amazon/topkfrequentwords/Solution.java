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
package ga.rugal.lintcode.amazon.topkfrequentwords;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://www.lintcode.com/problem/top-k-frequent-words/description
 *
 * @author rugal
 */
public class Solution {

  /**
   * @param words: an array of string
   * @param k:     An integer
   *
   * @return an array of string
   */
  public String[] topKFrequentWords(final String[] words, final int k) {
    if (k == 0 || words.length == 0) {
      return new String[0];
    }
    final Map<String, Integer> map = new HashMap<>();
    for (String w : words) {
      if (!map.containsKey(w)) {
        map.put(w, 0);
      }
      map.put(w, map.get(w) + 1);
    }
    final PriorityQueue<Map.Entry<String, Integer>> q = new PriorityQueue<>((a, b) -> !a.getValue().equals(b.getValue())
                                                                                      ? a.getValue() - b.getValue()
                                                                                      : b.getKey().compareTo(a.getKey()));
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      if (q.size() < k) {
        q.offer(entry);
        continue;
      }
      if (entry.getValue() > q.peek().getValue()
          || entry.getValue().equals(q.peek().getValue())
             && q.peek().getKey().compareTo(entry.getKey()) > 0) {
        q.poll();
        q.offer(entry);
      }
    }

    final String[] result = new String[k];
    for (int i = k - 1; i >= 0 && !q.isEmpty(); --i) {
      result[i] = q.poll().getKey();
    }

    return result;
  }
}
