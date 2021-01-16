package ga.rugal.amazon.coursescheduleii;

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

  public int[] findOrder(int numCourses, final int[][] prerequisites) {
    final Graph g = new Graph(numCourses);
    for (int[] pre : prerequisites) {
      g.addEdge(pre[1], pre[0]);
    }

    final Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < g.nVertices; i++) {
      //courses that have no prerequisite
      if (g.inDegrees[i] == 0) {
        queue.add(i);
      }
    }
    final List<Integer> result = new ArrayList<>();
    //start from courses that have no prerequisite
    for (; !queue.isEmpty(); --numCourses) {
      final int poll = queue.poll();
      result.add(poll);
      g.adjacencyList[poll].stream()
        //similarly, add these that have no prerequisite after removing the up relationship
        .filter(node -> (0 == --g.inDegrees[node]))
        .forEachOrdered(node -> queue.add(node));
    }

    return numCourses == 0
           ? result.stream().mapToInt(Integer::intValue).toArray()
           : new int[0];
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
