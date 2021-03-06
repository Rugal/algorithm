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
package ga.rugal.leetcode.coursescheduleii;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/course-schedule-ii/
 *
 * @author rugalbernstein
 */
public class Solution {

  public int[] findOrder(final int numCourses, final int[][] prerequisites) {
    final Graph g = new Graph(numCourses);
    for (int[] pre : prerequisites) {
      g.addEdge(pre[1], pre[0]);
    }

    final Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      //courses that have no prerequisite
      if (g.inDegrees[i] == 0) {
        queue.add(i);
      }
    }
    final List<Integer> result = new ArrayList<>();
    int topSortNodes = numCourses;
    //start from courses that have no prerequisite
    while (!queue.isEmpty()) {
      final int curr = queue.poll();
      result.add(curr);
      topSortNodes--;
      final List<Integer> neighbors = g.adjacencyList[curr];
      for (int node : neighbors) {
        //similarly, add these that have no prerequisite after removing the up relationship
        if (0 == --g.inDegrees[node]) {
          queue.add(node);
        }
      }
    }

    return topSortNodes == 0
           ? result.stream()
              .mapToInt(Integer::intValue)
              .toArray()
           : new int[0];
  }

  class Graph {

    final LinkedList<Integer>[] adjacencyList;

    /**
     * How many edges connect to this vertices. 0 means it is a start.
     */
    final int[] inDegrees;

    Graph(int n) {
      this.inDegrees = new int[n];
      this.adjacencyList = new LinkedList[n];
      for (int i = 0; i < n; i++) {
        this.adjacencyList[i] = new LinkedList<>();
      }
    }

    private void addEdge(int src, int destination) {
      this.adjacencyList[src].add(destination);
      this.inDegrees[destination]++;
    }
  }
}
