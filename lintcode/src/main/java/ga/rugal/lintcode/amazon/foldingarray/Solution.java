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
package ga.rugal.lintcode.amazon.foldingarray;

/**
 * https://www.lintcode.com/problem/folding-array/description
 *
 * @author rugalbernstein
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

  /*
   * @param : the original array @param : the direction each time @return: the final folded array
   */
  public int[] folding(int[] nums, int[] req) {
    // write your code here
    int factor = 0;
    for (int i = 0; i < req.length; i++) {
      if (i == 0) {
        factor = 1;
      } else {
        factor = 2 * factor;
      }
      if (req[i] == 0) {
        nums = left2Right(nums, factor);
      } else {
        nums = right2Left(nums, factor);
      }
    }
    return nums;
  }

  //    右半边逆序在前，左半边不动在后
  private int[] right2Left(int[] nums, int factor) {
    int length = nums.length / factor;
    List<Integer> list = new ArrayList<>();
    List<Integer> rightList = new ArrayList<>();
    for (int i = 0; i < factor; i++) {
      for (int j = 0; j < length; j++) {
        if (j < length / 2) {
          list.add(nums[length * i + j]);
        } else {
          rightList.add(nums[length * i + j]);
        }
      }
    }
    Collections.reverse(rightList);
    int[] res = new int[nums.length];
    for (int i = 0; i < res.length; i++) {
      if (i < res.length / 2) {
        res[i] = rightList.get(i);
      } else {
        res[i] = list.get(i - res.length / 2);
      }
    }
    return res;
  }

  //    左半边逆序在前，右半边不动在后
  private int[] left2Right(int[] nums, int factor) {
    int length = nums.length / factor;
    List<Integer> list = new ArrayList<>();
    List<Integer> rightList = new ArrayList<>();
    for (int i = 0; i < factor; i++) {
      for (int j = 0; j < length; j++) {
        if (j < length / 2) {
          list.add(nums[length * i + j]);
        } else {
          rightList.add(nums[length * i + j]);
        }
      }
    }
    Collections.reverse(list);
    int[] res = new int[nums.length];
    for (int i = 0; i < res.length; i++) {
      if (i < res.length / 2) {
        res[i] = list.get(i);
      } else {
        res[i] = rightList.get(i - res.length / 2);
      }
    }
    return res;
  }
}
