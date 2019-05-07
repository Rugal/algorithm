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
package ga.rugal.leetcode.uglynumber;

/**
 * https://leetcode.com/problems/ugly-number/
 *
 * @author rugal
 */
public class Solution {

  boolean isUgly(int num) {
    if (num <= 0) {
      return false;
    }
    for (; num % 2 == 0; num /= 2);
    for (; num % 3 == 0; num /= 3);
    for (; num % 5 == 0; num /= 5);
    return num == 1;
  }
}
