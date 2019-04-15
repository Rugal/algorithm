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
package ga.rugal.leetcode.redundantconnection;

/**
 * https://leetcode.com/problems/redundant-connection/
 *
 * @author rugalbernstein
 */
public class Solution {

  public int[] findRedundantConnection(final int[][] edges) {
    final UnionFindSet set = new UnionFindSet(edges.length);
    for (int i = 0; i < edges.length; ++i) {
      if (!set.union(edges[i][0], edges[i][1])) {
        return edges[i];
      }
    }
    return null;
  }

  private static class UnionFindSet {

    private final int[] rank;

    private final int[] parent;

    public UnionFindSet(final int n) {
      this.rank = new int[n + 1];
      this.parent = new int[n + 1];

      for (int i = 0; i < this.parent.length; ++i) {
        this.parent[i] = i;
      }
    }

    /**
     * Find the representative of element.
     *
     * @param i
     *
     * @return
     */
    int find(final int u) {
      if (u != this.parent[u]) {
        this.parent[u] = this.find(this.parent[u]);
      }
      return this.parent[u];
    }

    /**
     * Union 2 element into one set by rank and path compression.
     *
     * @param left
     * @param right
     *
     * @return false if the 2 elements are already in one set, otherwise return true
     */
    boolean union(final int left, final int right) {
      final int x = this.find(left);
      final int y = this.find(right);
      if (x == y) {
        //no merge need
        return false;
      }
      if (this.rank[y] > this.rank[x]) {
        this.parent[x] = y;
        return true;
      }
      if (this.rank[y] < this.rank[x]) {
        this.parent[y] = x;
        return true;
      }
      this.parent[y] = x;
      ++this.rank[x];
      return true;
    }
  }
}
