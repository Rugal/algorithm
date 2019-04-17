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
package ga.rugal.leetcode.rectangleoverlap;

/**
 * https://leetcode.com/problems/rectangle-overlap/
 *
 * @author rugal
 */
public class Solution {

  public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
    return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0]) // width > 0
            && Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));  // height > 0
  }
}
