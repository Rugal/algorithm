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
package ga.rugal.leetcode.findsmallestlettergreaterthantarget;

/**
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/
 *
 * @author rugal
 */
public class Solution {

  public char nextGreatestLetter(final char[] letters, final char target) {
    int lo = 0, hi = letters.length;
    while (lo < hi) {
      int mi = lo + (hi - lo) / 2;
      if (letters[mi] <= target) {
        lo = mi + 1;
      } else {
        hi = mi;
      }
    }
    return letters[lo % letters.length];
  }
}
