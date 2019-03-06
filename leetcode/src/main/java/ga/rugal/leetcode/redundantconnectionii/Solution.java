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
package ga.rugal.leetcode.redundantconnectionii;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/redundant-connection-ii/
 *
 * @author rugalbernstein
 */
public class Solution {

  int parent[];

  public int[] findRedundantDirectedConnection(int[][] edges) {
    this.parent = new int[edges.length + 1];
    List<Integer> parents[] = new List[edges.length + 1];
    for (int i = 0; i < parents.length; i++) {
      parents[i] = new ArrayList<>();
    }

    for (int[] edge : edges) {
      parents[edge[1]].add(edge[0]);
      if (parents[edge[1]].size() == 2) {
        for (int j = 1; j >= 0; j--) {
          int[] redundant = {parents[edge[1]].get(j), edge[1]};
          if (isValidWithoutEdge(redundant, edges)) {
            return redundant;
          }
        }
      }
    }

    return findAnyInvalidEdge(edges);
  }

  int[] findAnyInvalidEdge(int[][] edges) {

    for (int i = 0; i < parent.length; i++) {
      parent[i] = i;
    }

    for (int[] edge : edges) {
      int p1 = getParent(parent, edge[0]);
      int p2 = getParent(parent, edge[1]);

      if (p1 == p2 || p2 != edge[1]) {
        return edge;
      }

      parent[p2] = p1;
    }

    return edges[edges.length - 1];
  }

  boolean isValidWithoutEdge(int[] redundant, int[][] edges) {
    for (int i = 0; i < parent.length; i++) {
      parent[i] = i;
    }

    for (int edge[] : edges) {
      if (edge[0] == redundant[0] && edge[1] == redundant[1]) {
        continue;
      }
      int p1 = getParent(parent, edge[0]);
      int p2 = getParent(parent, edge[1]);

      parent[p2] = p1;
    }

    for (int i = 2; i < parent.length; i++) {
      if (getParent(parent, i) != getParent(parent, i - 1)) {
        return false;
      }
    }
    return true;
  }

  int getParent(int[] parent, int v) {
    int p = parent[v];
    while (p != parent[p]) {
      p = parent[p];
    }
    return p;
  }
}
