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
package ga.rugal.lintcode.amazon.graycode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.lintcode.com/problem/gray-code/description
 *
 * @author rugal
 */
public class Solution {

  /**
   * @param n: a number
   *
   * @return Gray code
   */
  public List<Integer> grayCode(final int n) {
    final List<Integer> result = new ArrayList<>();
    result.add(0);
    for (int i = 1; i <= n; ++i) {
      final int size = result.size();
      final int base = 1 << (i - 1);
      for (int j = size - 1; j >= 0; --j) {
        result.add(result.get(j) + base);
      }
    }
    return result;
  }
}
