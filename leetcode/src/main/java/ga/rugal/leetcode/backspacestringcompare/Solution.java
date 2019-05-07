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
package ga.rugal.leetcode.backspacestringcompare;

/**
 * https://leetcode.com/problems/backspace-string-compare/
 *
 * @author rugal
 */
public class Solution {

  public boolean backspaceCompare(String S, String T) {
    int i = S.length() - 1, j = T.length() - 1;
    int skipS = 0, skipT = 0;

    while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
      while (i >= 0) { // Find position of next possible char in build(S)
        if (S.charAt(i) == '#') {
          skipS++;
          i--;
        } else if (skipS > 0) {
          skipS--;
          i--;
        } else {
          break;
        }
      }
      while (j >= 0) { // Find position of next possible char in build(T)
        if (T.charAt(j) == '#') {
          skipT++;
          j--;
        } else if (skipT > 0) {
          skipT--;
          j--;
        } else {
          break;
        }
      }
      // If two actual characters are different
      if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) {
        return false;
      }
      // If expecting to compare char vs nothing
      if ((i >= 0) != (j >= 0)) {
        return false;
      }
      i--;
      j--;
    }
    return true;
  }
}
