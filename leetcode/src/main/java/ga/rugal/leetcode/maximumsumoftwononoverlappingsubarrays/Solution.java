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
package ga.rugal.leetcode.maximumsumoftwononoverlappingsubarrays;

/**
 * https://leetcode.com/contest/weekly-contest-133/problems/maximum-sum-of-two-non-overlapping-subarrays/
 *
 * @author rugal
 */
public class Solution {

  private int data[];

  public int maxSumTwoNoOverlap(int[] A, int L, int M) {
    this.data = A;
    final int[] array1 = this.slide(L);
    final int[] array2 = this.slide(M);
    int max = Integer.MIN_VALUE;
    for (int ileft = 0; ileft < array1.length; ++ileft) {
      for (int jleft = 0; jleft < array2.length; ++jleft) {

        final int iright = ileft + L - 1;
        final int jright = jleft + M - 1;

        if (jleft > iright || ileft > jright) {
          max = Integer.max(array1[ileft] + array2[jleft], max);
        }
      }
    }
    return max;
  }

  private int[] slide(final int n) {
    final int[] result = new int[this.data.length - n + 1];
    for (int i = 0; i < n; ++i) {
      result[0] += this.data[i];
    }
    for (int i = n; i < this.data.length; ++i) {
      result[i - n + 1] = result[i - n] + this.data[i] - this.data[i - n];
    }
    return result;
  }
}
