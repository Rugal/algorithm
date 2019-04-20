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
package ga.rugal.lintcode.amazon.longestpalindromicsubstring;

/**
 * https://www.lintcode.com/problem/longest-palindromic-substring
 *
 * @author rugal
 */
public class Solution {

  public String longestPalindrome(final String s) {
    if (s == null || s.length() == 0) {
      return "";
    }

    // abc => #a#b#c#
    final String str = generateString(s);

    final int[] palindrome = new int[str.length()];
    int mid = 0, longest = 1;
    palindrome[0] = 1;
    for (int i = 1; i < str.length(); i++) {
      int len = 1;
      //from center of currently longest palindrome, if i is within that range
      if (mid + longest > i) {
        final int mirrorOfI = mid - (i - mid);
        //https://www.felix021.com/blog/read.php?2040
        len = Math.min(palindrome[mirrorOfI], mid + longest - i);
      }
      for (; i + len < str.length() && i - len >= 0; len++) {
        if (str.charAt(i - len) != str.charAt(i + len)) {
          break;
        }
      }

      if (len > longest) {
        longest = len;
        mid = i;
      }

      palindrome[i] = len;
    }

    longest = longest - 1; // remove the extra #
    int start = (mid - 1) / 2 - (longest - 1) / 2;
    return s.substring(start, start + longest);
  }

  private String generateString(final String s) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      sb.append('#');
      sb.append(s.charAt(i));
    }
    sb.append('#');

    return sb.toString();
  }
}
