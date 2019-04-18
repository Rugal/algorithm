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
package ga.rugal.lintcode.amazon.longestpalindrome;

/**
 * https://www.lintcode.com/problem/longest-palindrome/description
 *
 * @author rugal
 */
public class Solution {

  /**
   * @param s: a string which consists of lowercase or uppercase letters
   *
   * @return the length of the longest palindromes that can be built
   */
  public int longestPalindrome(final String s) {
    final int[] count = new int['z' - 'A' + 1];
    for (char c : s.toCharArray()) {
      ++count[c - 'A'];
    }
    int length = 0;
    for (int c : count) {
      length += c / 2 * 2;
      if (length % 2 == 0 && c % 2 == 1) {
        ++length;
      }
    }
    return length;
  }
}
