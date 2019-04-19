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
package ga.rugal.lintcode.amazon.highfive;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

import ga.rugal.lintcode.Record;

/**
 * https://www.lintcode.com/problem/high-five/description
 *
 * @author rugal
 */
public class Solution {

  private static final int NUMBER = 5;

  /**
   * @param records a list of <student_id, score>
   *
   * @return find the average of 5 highest scores for each person Map<Integer, Double> (student_id,
   *         average_score)
   */
  public Map<Integer, Double> highFive(final Record[] records) {
    final Map<Integer, PriorityQueue<Integer>> students = new HashMap<>();
    for (Record r : records) {
      if (!students.containsKey(r.id)) {
        students.put(r.id, new PriorityQueue<>());
      }
      final PriorityQueue<Integer> get = students.get(r.id);
      if (get.size() < NUMBER) {
        get.offer(r.score);
        continue;
      }
      if (r.score > get.peek()) {
        get.poll();
        get.offer(r.score);
      }
    }

    return students.entrySet().stream()
      .collect(Collectors.toMap(k -> k.getKey(),
                                v -> 1.0 * v.getValue().stream()
                                  .reduce(0, Integer::sum) / NUMBER));

  }
}
