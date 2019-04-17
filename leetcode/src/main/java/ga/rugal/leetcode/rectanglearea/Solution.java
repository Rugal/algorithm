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
package ga.rugal.leetcode.rectanglearea;

/**
 * https://leetcode.com/problems/rectangle-area/
 *
 * @author rugal
 */
public class Solution {

  public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    int left = Math.max(A, E);//left side
    //consider the right top corner move to the left
    //in this case we have to ensure that the right side must be to the right to left side
    int right = Math.max(Math.min(C, G), left);
    int bottom = Math.max(B, F);//right side
    //same story applies here, even thought the regular way te get right side is min(C, G)
    //becaule it is possible that right top corner move down to the bottom
    //we need to screen that case
    int top = Math.max(Math.min(D, H), bottom);
    return (C - A) * (D - B) - (right - left) * (top - bottom) + (G - E) * (H - F);
  }
}
