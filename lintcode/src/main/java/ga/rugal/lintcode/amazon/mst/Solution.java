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
package ga.rugal.lintcode.amazon.mst;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://www.lintcode.com/problem/minimum-spanning-tree
 *
 * @author rugal
 */
public class Solution {

  private String getKey(final List<Integer> l) {
    return String.format("%s,%s", l.get(0), l.get(1));
  }

  /**
   * totalCity == totalRoad + 1
   *
   * @param totalAvailableCity
   * @param totalAvailableRoad
   * @param availableRoad
   * @param roadToRepair
   * @param roadRepairCost
   *
   * @return
   */
  public int getMST(final int totalAvailableCity,
                    final int totalAvailableRoad,
                    final List<List<Integer>> availableRoad,
                    final int roadToRepair,
                    final List<List<Integer>> roadRepairCost) {
    //order by cost ascend
    Collections.sort(roadRepairCost, (a, b) -> a.get(2) - b.get(2));
    //unique set of road to repair
    final Set<String> set = roadRepairCost.stream()
      .map(this::getKey)
      .collect(Collectors.toSet());

    final UnionFindSet ufs = new UnionFindSet(totalAvailableCity);
    //number of available path that is not connected
    int disconnectedPathCount = availableRoad.stream()
      .filter(p -> !set.contains(this.getKey(p))
                   && ufs.union(p.get(0), p.get(1))) //not in the same group
      .map(p -> 1)
      .reduce(0, Integer::sum);

    int result = 0;
    //the minimum number of path to connect all city is [city - 1]
    if (disconnectedPathCount >= totalAvailableCity - 1) {
      //already connected
      return result;
    }
    for (List<Integer> r : roadRepairCost) {
      //if some cities are unreachable, connect them
      if (ufs.union(r.get(0), r.get(1))) {
        ++disconnectedPathCount;
        result += r.get(2);
        if (disconnectedPathCount >= totalAvailableCity - 1) {
          return result;
        }
      }
    }
    return -1;
  }

  private class UnionFindSet {

    int[] degree;

    int[] parent;

    public UnionFindSet(final int n) {
      this.degree = new int[n + 1];
      this.parent = new int[n + 1];
      for (int i = 0; i < this.parent.length; ++i) {
        this.parent[i] = i;
      }
    }

    public int find(final int i) {
      if (i != this.parent[i]) {
        this.parent[i] = this.find(this.parent[i]);
      }
      return this.parent[i];
    }

    public boolean isSame(final int i, final int j) {
      return this.find(i) == this.find(j);
    }

    public boolean union(final int i, final int j) {
      if (this.isSame(i, j)) {
        return false;
      }
      final int x = this.find(i);
      final int y = this.find(j);

      if (this.degree[x] > this.degree[y]) {
        this.parent[y] = x;
        return true;
      }
      if (this.degree[x] < this.degree[y]) {
        this.parent[x] = y;
        return true;
      }
      this.parent[y] = x;
      ++this.degree[x];
      return true;
    }
  }
}
