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

/**
 * https://leetcode.com/problems/redundant-connection-ii/
 *
 * @author rugalbernstein
 */
public class Solution {
    /*
    We still use unionFind to solve this question, but it has two kind of cases
    Case 1: No duplicate parents, return the first edge that creates the loop --> Same as 684
    Case 2: A node has two parents {u1, u2}
        2.1: return the second edge that creates duplicate parents (no loop). Example:[[1,2], [1,3], [2,3]]
                      1
                     / \
                    v   v
                    2-->3    Node 3 has two parents: 1 and 2. Remove any one of the edge satisfy the question. But we need to remove the one that occurs the last.
        2.2: return edge {u1, v} or edge {u2, v} that creates the loop. Example:[[2,1],[3,1],[4,2],[1,4]]
                    2----> 1 <-- 3
                    \     /
                     \   /
                      \-4    Node 1 has two parents. We have to remove either {2,1} or {3,1}. {2,1} is the one that creates the loop. So we remove {2,1}

	So our algorithm uses two loops: First loop to detect if there is any duplicate parents.
	2nd loop to detect if there is any loop in the graph.
    */
  static class UnionFind {

    int[] parents;

    public UnionFind(int N) {
      parents = new int[N];
      for (int i = 0; i < N; i++) {
        parents[i] = i;
      }
    }

    public void union(int x, int y) {
      parents[find(x)] = find(y);
    }

    public int find(int x) {
      if (x != parents[x]) {
        parents[x] = find(parents[x]);
      }
      return parents[x];
    }
  }

  public int[] findRedundantDirectedConnection(final int[][] edges) {
    int[] edge1 = new int[2];
    int[] edge2 = new int[2];
    {
      /*
       * Possible two edges(Two parents) in cases 2.
       */
      final int[] parent = new int[edges.length + 1];
      for (int[] edge : edges) {
        /*
         * First loop to detect if there is duplicate parents
         */
        final int nodeU = edge[0];
        final int nodeV = edge[1];
        if (parent[nodeV] > 0) {
          /*
           * there is duplicate parents
           */
          edge1 = new int[]{parent[nodeV], nodeV};
          /*
           * Add previous/first edge
           */
          edge2 = new int[]{nodeU, nodeV};/*
           * Add 2nd edge
           */
          edge[0] = -1;
          edge[1] = -1;
          /*
           * Delete the 2nd edge first
           */
        }
        parent[nodeV] = nodeU;
      }
    }
    final UnionFind uf = new UnionFind(edges.length + 1);
    for (int[] edge : edges) {
      int nodeU = edge[0];
      int nodeV = edge[1];
      if (nodeU < 0 || nodeV < 0) {
        continue;
        /*
         * This is for the deleted edge we have done in first loop.
         */
      }
      int rootU = uf.find(nodeU);
      int rootV = uf.find(nodeV);
      if (rootU == rootV) {
        /*
         * Since we already deleted the 2nd edge, then it must be edge1. If edge1 is not assigned
         * with any values.
         */
        return edge1[0] == 0
               ? new int[]{nodeU, nodeV}
               : edge1;
        /*
         * Then it means there is no duplicate parents. So case1: return current detected edge.
         */
      }
      uf.union(nodeU, nodeV);
    }
    return edge2;
    /*
     * If reached here, it means there is no loop detected, otherwise it would return at 2nd loop in
     * our code. So case 2.1, return 2nd edge.
     */
  }
}
