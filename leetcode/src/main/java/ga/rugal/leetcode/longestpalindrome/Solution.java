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
package ga.rugal.leetcode.longestpalindrome;

/**
 * https://leetcode.com/problems/longest-palindrome/
 *
 * @author rugalbernstein
 */
public class Solution {

  /**
   * There will have 2 types of palindrome.<BR>
   * XYX and XX<BR>
   * the number of X will always be even<BR>
   * There will have at most 1 Y<BR>
   *
   * @param s
   *
   * @return
   */
  public int longestPalindrome(final String s) {
    final int length = 'z' - 'A' + 1;
    final int[] map = new int[length];
    for (int i = 0; i < s.length(); ++i) {
      map[s.charAt(i) - 'A']++;
    }
    int result = 0;
    for (final int v : map) {
      //if v is even, it can all be put into string
      //if odd, there will have some pairs that can be put into string, but with 1 character left
      result += (v / 2 * 2);
      if (result % 2 == 0 //only if result is even
          && v % 2 == 1) {//and v is odd
        //in this case, there have no 1 character been added to string, so we are allowed to do so
        //but going forward, it is not allowed as we will have XYZX format, which is not palindrome
        ++result;
      }
    }
    return result;
  }
}
