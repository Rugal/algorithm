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
package ga.rugal.leetcode.validnumber;

/**
 * https://leetcode.com/problems/valid-number/
 *
 * @author rugal
 */
public class Solution {

  public boolean isNumber(String s) {
    try {
      s = s.trim();
      int n = s.length();
      if (n == 0 || (s.charAt(n - 1) != '.' && (s.charAt(n - 1) - '0' < 0 || s.charAt(n - 1) - '0' > 9))) {
        return false;
      }
      double i = Double.parseDouble(s);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }
}
