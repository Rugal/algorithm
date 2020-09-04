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
package ga.rugal.amazon.intersectionoftwoarraysii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii
 *
 * @author rugalbernstein
 */
public class Solution {

  /**
   * The result can be in any order.
   *
   * @param nums1
   * @param nums2
   *
   * @return
   */
  public int[] intersect(int[] nums1, int[] nums2) {
    final Map<Integer, Integer> map = new HashMap<>();
    for (int n : nums1) {
      final int orDefault = map.getOrDefault(n, 0);
      map.put(n, orDefault + 1);
    }

    final List<Integer> result = new ArrayList<>();
    for (int n : nums2) {
      if (map.containsKey(n) && map.get(n) > 0) {
        result.add(n);
        map.put(n, map.get(n) - 1);
      }
    }

    return result.stream()
      .mapToInt(i -> i)
      .toArray();
  }
}
