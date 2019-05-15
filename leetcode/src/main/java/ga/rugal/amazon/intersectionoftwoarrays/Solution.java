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
package ga.rugal.amazon.intersectionoftwoarrays;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays/
 *
 * @author rugalbernstein
 */
public class Solution {

  public int[] intersection(int[] nums1, int[] nums2) {
    HashSet<Integer> set1 = new HashSet<>();
    for (Integer n : nums1) {
      set1.add(n);
    }
    HashSet<Integer> set2 = new HashSet<>();
    for (Integer n : nums2) {
      set2.add(n);
    }

    set1.retainAll(set2);

    int[] output = new int[set1.size()];
    int idx = 0;
    for (int s : set1) {
      output[idx++] = s;
    }
    return output;
  }
}
