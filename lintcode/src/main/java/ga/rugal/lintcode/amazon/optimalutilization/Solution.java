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
package ga.rugal.lintcode.amazon.optimalutilization;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED

public class Solution {
  // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED

  public List<List<Integer>> optimalUtilization(final int maxTravelDist,
                                                final List<List<Integer>> forwardRouteList,
                                                final List<List<Integer>> returnRouteList) {
    if (maxTravelDist == 0 || forwardRouteList.isEmpty() || returnRouteList.isEmpty()) {
      return new ArrayList<>();
    }
    //first find if there is such right target exists
    Collections.sort(returnRouteList, (a, b) -> a.get(1) - b.get(1));
    Collections.sort(forwardRouteList, (a, b) -> a.get(1) - b.get(1));

    //if it is, find all pair that matched.
    //then it is a 2 sum problem
    //otherwise, return the one that is the closest
    return this.closest(forwardRouteList, returnRouteList, maxTravelDist);
  }

  private List<List<Integer>> closest(List<List<Integer>> forward,
                                      List<List<Integer>> backward,
                                      int target) {
    final List<List<Integer>> result = new ArrayList<>();
    int minDiff = Integer.MAX_VALUE;
    for (int i = 0, j = backward.size() - 1; i < forward.size() && j >= 0;) {
      final int temp = forward.get(i).get(1) + backward.get(j).get(1);
      if (temp > target) {
        --j;
        continue;
      }
      final int diff = Math.abs(temp - target);
      if (diff > minDiff) {
        continue;
      }
      final List<Integer> a = new ArrayList<>();
      //might have duplication
      a.add(forward.get(i).get(0));
      a.add(backward.get(j).get(0));
      if (diff < minDiff) {
        minDiff = diff;
        //clear previous
        //might have duplication
        //careful
        result.clear();
      }
      result.add(a);
      ++i;
    }
    return result;
  }
  // METHOD SIGNATURE ENDS
}
