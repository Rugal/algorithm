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
package ga.rugal.lintcode.amazon.minimumspanningtree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ga.rugal.lintcode.Connection;

/**
 * https://www.lintcode.com/problem/minimum-spanning-tree/description
 *
 * @author rugal
 */
public class Solution {

  private final Map<String, Integer> id = new HashMap<>();

  /**
   *
   * @param connections given a list of connections include two cities and cost
   *
   * @return a list of connections from results
   */
  public List<Connection> lowestCost(List<Connection> connections) {
    Collections.sort(connections, (a, b) -> a.cost != b.cost
                                            ? a.cost - b.cost
                                            : !a.city1.equals(b.city1)
                                              ? a.city1.compareTo(b.city1)
                                              : a.city2.compareTo(b.city2));
    final List<Connection> result = new ArrayList<>();
    final UnionFindSet ufs = new UnionFindSet(connections.size());
    for (Connection c : connections) {
      final int id1 = this.getId(c.city1);
      final int id2 = this.getId(c.city2);
      if (!ufs.isSame(id1, id2)) {
        ufs.union(id1, id2);
        result.add(c);
      }
    }
    return result.size() + 1 == this.id.size()
           ? result
           : new ArrayList<>();
  }

  /**
   * Map city name to id for Union Find Set
   *
   * @param name
   *
   * @return
   */
  private int getId(final String name) {
    if (!this.id.containsKey(name)) {
      this.id.put(name, this.id.size());
    }
    return this.id.get(name);
  }

  private class UnionFindSet {

    int[] parent;

    int[] rank;

    public UnionFindSet(final int n) {
      this.parent = new int[n];
      this.rank = new int[n];
      for (int i = 0; i < n; ++i) {
        this.parent[i] = i;
      }
    }

    public boolean isSame(final int i, final int j) {
      return this.find(i) == this.find(j);
    }

    public int find(final int i) {
      if (i != this.parent[i]) {
        this.parent[i] = this.find(this.parent[i]);
      }
      return this.parent[i];
    }

    public boolean union(final int i, final int j) {
      final int x = this.find(i);
      final int y = this.find(j);
      if (x == y) {
        return false;
      }
      if (this.rank[x] > this.rank[y]) {
        this.parent[y] = x;
        return true;
      }
      if (this.rank[x] < this.rank[y]) {
        this.parent[x] = y;
        return true;
      }
      this.parent[y] = x;
      ++this.rank[x];
      return true;
    }
  }
}
