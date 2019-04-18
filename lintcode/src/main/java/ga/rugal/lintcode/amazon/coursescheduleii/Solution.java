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
package ga.rugal.lintcode.amazon.coursescheduleii;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://www.lintcode.com/problem/course-schedule-ii/description
 *
 * @author rugal
 */
public class Solution {

  /**
   * @param numCourses:   a total of n courses @param prerequisites: a list of prerequisite pairs
   * @param prerequisites
   *
   * @return the course order
   */
  public int[] findOrder(final int numCourses, final int[][] prerequisites) {
    final Graph g = new Graph(numCourses);
    for (int[] p : prerequisites) {
      g.add(p[1], p[0]);
    }
    final Queue<Integer> q = new LinkedList();
    for (int i = 0; i < g.degree.length; ++i) {
      if (g.degree[i] == 0) {
        q.offer(i);
      }
    }
    final List<Integer> result = new ArrayList<>();
    int check = numCourses;
    while (!q.isEmpty()) {
      final int poll = q.poll();
      --check;
      result.add(poll);
      for (int i : g.adjacency[poll]) {
        if (--g.degree[i] == 0) {
          q.offer(i);
        }
      }
    }

    return check == 0
           ? result.stream()
              .mapToInt(Integer::intValue)
              .toArray()
           : new int[0];
  }

  class Graph {

    int[] degree;

    LinkedList<Integer>[] adjacency;

    public Graph(final int n) {
      this.degree = new int[n];
      this.adjacency = new LinkedList[n];
      for (int i = 0; i < n; i++) {
        this.adjacency[i] = new LinkedList<>();
      }
    }

    public void add(final int prerequisit, final int course) {
      ++this.degree[course];
      this.adjacency[prerequisit].add(course);
    }
  }
}
