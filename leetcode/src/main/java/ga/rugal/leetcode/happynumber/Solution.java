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
package ga.rugal.leetcode.happynumber;

/**
 * https://leetcode.com/problems/happy-number/
 *
 * @author rugal
 */
public class Solution {

  //math solution
  public boolean isHappy(int n) {
    while (n != 1) {
      final String s = Integer.toString(n);
      int nextn = 0;
      for (int i = 0; i < s.length(); ++i) {
        final int num = s.charAt(i) - '0';
        nextn += num * num;
      }
      n = nextn;
      if (n < 10 && n != 1 && n != 7) {
        return false;
      }
    }
    return true;
  }

  //convert into cyclic link list problem
  public boolean isHappy2(int n) {
    int x = n;
    int y = n;
    while (x > 1) {
      x = cal(x);
      if (x == 1) {
        return true;
      }
      y = cal(cal(y));
      if (y == 1) {
        return true;
      }

      if (x == y) {
        return false;
      }
    }
    return true;
  }

  public int cal(int n) {
    int x = n;
    int s = 0;
    while (x > 0) {
      s = s + (x % 10) * (x % 10);
      x = x / 10;
    }
    return s;
  }
}
