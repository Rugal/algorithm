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
package ga.rugal.lintcode.amazon.rectangleoverlap;

import ga.rugal.lintcode.Point;

/**
 * https://www.lintcode.com/problem/rectangle-overlap/description
 *
 * @author rugal
 */
public class Solution {

  /**
   * @param l1: top-left coordinate of first rectangle
   * @param r1: bottom-right coordinate of first rectangle
   * @param l2: top-left coordinate of second rectangle
   * @param r2: bottom-right coordinate of second rectangle
   *
   * @return true if they are overlap or false
   */
  public boolean doOverlap(Point l1, Point r1, Point l2, Point r2) {
    return Integer.max(l1.x, l2.x) <= Integer.min(r1.x, r2.x)
           && Integer.max(r1.y, r2.y) <= Integer.min(l1.y, l2.y);
  }
}
