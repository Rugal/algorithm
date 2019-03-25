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
package ga.rugal.leetcode.multiplystrings;

/**
 * https://leetcode.com/problems/multiply-strings/
 *
 * @author rugalbernstein
 */
public class Solution {

  private static final String ZERO = "0";

  public String multiply(final String num1, final String num2) {
    if (num1.equals(ZERO) || num2.equals(ZERO)) {
      return ZERO;
    }
    int m = num1.length(), n = num2.length();
    int[] pos = new int[m + n];

    for (int i = m - 1; i >= 0; i--) {
      for (int j = n - 1; j >= 0; j--) {
        int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
        int p1 = i + j, p2 = i + j + 1;
        //https://leetcode.com/problems/multiply-strings/discuss/17605/Easiest-JAVA-Solution-with-Graph-Explanation
        int sum = mul + pos[p2];

        pos[p1] += sum / 10;
        pos[p2] = (sum) % 10;
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int p : pos) {
      if (!(sb.length() == 0 && p == 0)) {
        sb.append(p);
      }
    }
    return sb.length() == 0 ? "0" : sb.toString();
  }
}
