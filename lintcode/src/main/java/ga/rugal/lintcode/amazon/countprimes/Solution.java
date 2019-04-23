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
package ga.rugal.lintcode.amazon.countprimes;

/**
 * https://www.lintcode.com/problem/count-primes/description
 *
 * @author rugal
 */
public class Solution {

  public int countPrimes(int n) {
    final boolean[] array = new boolean[n + 1];
    for (int i = 2; i < n; ++i) {
      for (; i < n + 1 && array[i]; ++i);
      for (int j = 2; i * j < n; ++j) {
        array[i * j] = true;
      }
    }

    int count = 0;
    for (int i = 2; i < n; ++i) {
      if (!array[i]) {
        count++;
      }
    }
    return count;
  }
}
