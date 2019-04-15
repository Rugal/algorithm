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
package ga.rugal.leetcode.nthdigit;

/**
 * https://leetcode.com/problems/nth-digit/
 *
 * @author rugal
 */
public class Solution {

  /**
   * sample   number  count
   * 1        1       9
   * 10       2       90
   * 100      3       900
   * 1000     4       9000
   *
   * @param n
   *
   * @return
   */
  public int findNthDigit(int n) {
    int digit = 1;
    long count = 9;
    while (n > digit * count) {
      n -= digit * count;
      ++digit;
      count *= 10;
    }
    // count / 9 is the base number
    // (n - 1) is the residual number, divided by digit is to the final number
    final int number = (int) (count / 9 + (n - 1) / digit);
    //but beware here, 2/2 == 3/2, that's why we need another variable below
    //2%2 will be 0, which is the very left first digit
    //3%2 will be 1, which is the second left digit etc.,
    final int d = (int) ((n - 1) % digit);
    return Long.toString(number).charAt(d) - '0';
  }
}
