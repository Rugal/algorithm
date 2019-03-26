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
package ga.rugal.leetcode.addbinary;

/**
 * https://leetcode.com/problems/add-binary/
 *
 * @author rugal
 */
public class Solution {

  public String addBinary(String a, String b) {
    if (a == null || b == null) {
      return a == null ? b : a;
    }

    int carry = 0;
    final StringBuilder sb = new StringBuilder();

    for (int i = a.length() - 1, j = b.length() - 1;
         i >= 0 || j >= 0 || carry > 0;
         i--, j--) {
      int sum = 0;
      sum += (i >= 0) ? a.charAt(i) - '0' : 0;
      sum += (j >= 0) ? b.charAt(j) - '0' : 0;
      sum += carry;

      carry = sum / 2;
      sum %= 2;
      sb.append(sum);
    }

    return sb.reverse().toString();
  }
}
