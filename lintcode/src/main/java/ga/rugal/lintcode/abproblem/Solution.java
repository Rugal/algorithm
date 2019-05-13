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
package ga.rugal.lintcode.abproblem;

/**
 * https://www.lintcode.com/problem/a-b-problem/description
 *
 * @author rugalbernstein
 */
public class Solution {

  /**
   * 主要利用异或运算来完成 异或运算有一个别名叫做：不进位加法<BR>
   * 那么a ^ b就是a和b相加之后，该进位的地方不进位的结果<BR>
   * 然后下面考虑哪些地方要进位，自然是a和b里都是1的地方<BR>
   * a & b就是a和b里都是1的那些位置， {@code a & b << 1} 就是进位之后的结果。<BR>
   * 所以：{@code a + b = (a ^ b) + (a & b << 1)}，令{@code a' = a ^ b, b' = (a & b) << 1}<BR>
   * 可以知道，这个过程是在模拟加法的运算过程，进位不可能一直持续，所以b最终会变为0。因此重复做上述操作就可以求得a + b的值。
   *
   * @param a: An integer
   * @param b: An integer
   *
   * @return The sum of a and b
   */
  public int aplusb(int a, int b) {
    while (b != 0) {
      int _a = a ^ b;
      int _b = (a & b) << 1;
      a = _a;
      b = _b;
    }
    return a;
  }
}
