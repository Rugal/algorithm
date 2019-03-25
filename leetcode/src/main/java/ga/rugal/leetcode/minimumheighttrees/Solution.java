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
package ga.rugal.leetcode.minimumheighttrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/minimum-height-trees
 *
 * @author rugal
 */
public class Solution {

  /**
   * Any undirect graph that can form a tree can have 2 MHT roots at most.
   *
   * @param n
   * @param edges
   *
   * @return
   */
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    final List<Integer> res = new ArrayList<>();
    if (n <= 0) {
      return res;
    }
    if (n == 1) {
      res.add(0);
      return res;
    }
    final Graph graph = new Graph(n);
    for (int[] edge : edges) {
      graph.addEdge(edge[0], edge[1]);
    }
    //like toposort
    final Queue<Integer> leaves = new LinkedList<>();
    for (int i = 0; i < graph.inDegrees.length; ++i) {
      if (graph.inDegrees[i] == 1) {
        leaves.add(i);
      }
    }

    int count = n;
    //exit if there is less than 2 elements according to the definition of MHT
    while (count > 2) {
      final int size = leaves.size();//get here first since the size will change internally
      count -= size;
      for (int i = 0; i < size; i++) {
        final int v = leaves.poll();
        for (int w : graph.adjacencyList[v]) {
          graph.inDegrees[w]--;
          //if this becomes the possible root, add it to leave candidates
          if (graph.inDegrees[w] == 1) {
            leaves.add(w);
          }
        }
      }
    }
    res.addAll(leaves);
    return res;
  }

  class Graph {

    final int nVertices;

    final LinkedList<Integer>[] adjacencyList;

    /**
     * How many edges connect to this vertices. 0 means it is a start.
     */
    final int[] inDegrees;

    Graph(int n) {
      this.nVertices = n;
      this.adjacencyList = new LinkedList[n];
      for (int i = 0; i < n; i++) {
        this.adjacencyList[i] = new LinkedList<>();
      }
      this.inDegrees = new int[n];
    }

    private void addEdge(int src, int destination) {
      this.adjacencyList[src].add(destination);
      this.adjacencyList[destination].add(src);
      this.inDegrees[src]++;
      this.inDegrees[destination]++;
    }
  }
}
