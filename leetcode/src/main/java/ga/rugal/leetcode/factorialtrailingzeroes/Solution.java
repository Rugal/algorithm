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
package ga.rugal.leetcode.factorialtrailingzeroes;

/**
 * https://leetcode.com/problems/factorial-trailing-zeroes/
 *
 * @author rugalbernstein
 */
public class Solution {

  /**
   * This is basically to calculate how many number of 10 can be produced by the factorial.<BR>
   * That is 2 x 5<BR>
   * But there are a lot more 2 than 5 does, so for simplicity we just count the number of 5.<BR>
   *
   * @param n
   * @return
   */
  public int trailingZeroes(int n) {
    int result = 0;
    while (n > 0) {
      result += (n /= 5);
    }
    return result;
  }
}
