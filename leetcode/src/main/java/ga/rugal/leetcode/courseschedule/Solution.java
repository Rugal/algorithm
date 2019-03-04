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
package ga.rugal.leetcode.courseschedule;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/course-schedule/
 *
 * @author rugalbernstein
 */
public class Solution {

  public boolean canFinish(final int numCourses, final int[][] prerequisites) {
    final Graph g = new Graph(numCourses);
    for (int[] pre : prerequisites) {
      g.addEdge(pre[0], pre[1]);
    }

    final Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < g.nVertices; i++) {
      if (g.inDegrees[i] == 0) {
        queue.add(i);
      }
    }
    int topSortNodes = g.nVertices;
    while (!queue.isEmpty()) {
      final int curr = queue.poll();
      topSortNodes--;
      final LinkedList<Integer> neighbors = g.adjacencyList[curr];
      for (int node : neighbors) {
        if (0 == --g.inDegrees[node]) {
          queue.add(node);
        }
      }
    }
    return topSortNodes == 0;
  }

  class Graph {

    final int nVertices;

    final LinkedList<Integer>[] adjacencyList;

    /**
     * How many edges connect to this vertices. 0 means it is a start.
     */
    final int[] inDegrees;

    Graph(int n) {
      nVertices = n;
      adjacencyList = new LinkedList[n];
      for (int i = 0; i < n; i++) {
        adjacencyList[i] = new LinkedList<>();
      }
      inDegrees = new int[n];
    }

    private void addEdge(int src, int destination) {
      adjacencyList[src].add(destination);
      inDegrees[destination]++;
    }
  }
}
