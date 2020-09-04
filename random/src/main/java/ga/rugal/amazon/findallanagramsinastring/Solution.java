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
package ga.rugal.amazon.findallanagramsinastring;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 *
 * @author rugalbernstein
 */
public class Solution {

  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> list = new ArrayList<>();
    if (s == null || s.length() == 0 || p == null || p.length() == 0) {
      return list;
    }
    final int[] hash = new int['z' - 'a' + 1]; //character hash
    //record each character in p to hash
    for (char c : p.toCharArray()) {
      hash[c - 'a']++;
    }
    //two points, initialize count to p's length
    int left = 0, right = 0, count = p.length();
    while (right < s.length()) {
      //right pointer moves all the time, and decrease the corresponding character hash count
      //but only touch the COUNT whenever character hash count > 0
      //which means we have this character in pattern
      //note that, any mismatched character hash count will be negative
      if (hash[s.charAt(right++) - 'a']-- > 0) {
        count--;
      }

      //when the count is down to 0, means we found the right anagram
      //then add window's left to result list
      if (count == 0) {
        list.add(left);
      }

      //left pointer moves only when we have enough number characters
      //if we do, then move it to right
      if (right - left == p.length()
          //also recover the character hash count back by 1
          //note that any matched character must have non-negative character hash count
          && hash[s.charAt(left++) - 'a']++ >= 0) {
        //if we deleted an matched character, we need to increase the COUNT
        count++;
      }
    }
    return list;
  }
}
