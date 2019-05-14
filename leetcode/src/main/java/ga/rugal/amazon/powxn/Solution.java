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
package ga.rugal.amazon.powxn;

/**
 * https://leetcode.com/problems/powx-n/
 *
 * @author rugalbernstein
 */
public class Solution {

  public double myPow(double x, final int n) {
    long N = n;
    if (N < 0) {
      x = 1 / x;
      N = -N;
    }
    double ans = 1;
    double current_product = x;
    for (long i = N; i > 0; i /= 2) {
      if (i % 2 == 1) {
        ans *= current_product;
      }
      current_product *= current_product;
    }
    return ans;
  }
}
