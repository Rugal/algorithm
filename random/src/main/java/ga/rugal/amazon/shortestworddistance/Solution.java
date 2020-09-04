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
package ga.rugal.amazon.shortestworddistance;

/**
 * https://leetcode.com/problems/shortest-word-distance/
 *
 * @author rugalbernstein
 */
public class Solution {

  public int shortestDistance(String[] words, String word1, String word2) {
    int i1 = -1, i2 = -1;
    int minDistance = words.length;
    for (int i = 0; i < words.length; i++) {
      if (words[i].equals(word1)) {
        i1 = i;
      } else if (words[i].equals(word2)) {
        i2 = i;
      }

      if (i1 != -1 && i2 != -1) {
        minDistance = Math.min(minDistance, Math.abs(i1 - i2));
      }
    }
    return minDistance;
  }

}
