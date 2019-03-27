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
package ga.rugal.leetcode.dividetwointegers;

/**
 * https://leetcode.com/problems/divide-two-integers/
 *
 * @author rugal
 */
public class Solution {

  public int divide(final int dividend, final int divisor) {
    if (dividend == Integer.MIN_VALUE && divisor == -1) {
      return Integer.MAX_VALUE;
    }
    final int sign = dividend > 0 ^ divisor > 0 ? -1 : 1;

    long count = 0;

    for (long dvd = Math.abs(dividend * 1L), dvs = Math.abs(divisor * 1L); dvd >= dvs;) {
      long temp = dvs, m = 1;
      while (temp << 1 <= dvd) {
        temp <<= 1;
        m <<= 1;
      }
      dvd -= temp;
      count += m;
    }
    return (int) count * sign;
  }
}
