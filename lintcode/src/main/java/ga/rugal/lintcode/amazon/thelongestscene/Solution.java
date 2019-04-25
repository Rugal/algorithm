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
package ga.rugal.lintcode.amazon.thelongestscene;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://www.lintcode.com/problem/the-longest-scene/description
 *
 * @author rugalbernstein
 */
public class Solution {

  /**
   * @param str: The scene string
   *
   * @return Return the length longest scene
   */
  public int getLongestScene(final String str) {
    final Map<Character, Point> map = new HashMap<>();

    for (int i = 0; i < str.length(); ++i) {
      final char c = str.charAt(i);
      if (map.containsKey(c)) {
        map.get(c).right = i;
      } else {
        map.put(c, new Point(i, -1));
      }
    }
    final List<Point> list = new ArrayList<>(map.values());
    Collections.sort(list);

    int max = -1;
    final LinkedList<Point> merged = new LinkedList<>();
    for (final Point interval : list) {
      // if the list of merged intervals is empty or if the current
      // interval does not overlap with the previous, simply append it.
      if (merged.isEmpty() || merged.getLast().right < interval.left) {
        merged.add(interval);
      } else {
        // otherwise, there is overlap, so we merge the current and previous intervals.
        merged.getLast().right = Math.max(merged.getLast().right, interval.right);
      }
      max = Integer.max(max, merged.getLast().right - merged.getLast().left + 1);
    }

    return max;
  }

  private class Point implements Comparable<Point> {

    int left;

    int right;

    public Point(int left, int right) {
      this.left = left;
      this.right = right;
    }

    @Override
    public int compareTo(Point o) {
      return this.left != o.left
             ? this.left - o.left
             : this.right - o.right;
    }
  }
}
