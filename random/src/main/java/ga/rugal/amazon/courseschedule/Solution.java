package ga.rugal.amazon.courseschedule;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/course-schedule/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  /**
   * Some courses may have prerequisites, for example to take course 0 you have to first take course
   * 1, which is expressed as a pair: [0,1]
   *
   *
   *
   * @param numCourses
   * @param prerequisites
   *
   * @return
   */
  public boolean canFinish(int numCourses, final int[][] prerequisites) {
    // build a graph
    final var g = new Graph(numCourses);
    for (int[] p : prerequisites) {
      g.addEdge(p[1], p[0]);
    }
    // find all courses that without prerequisite (independent course)
    final Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < g.inDegree.length; ++i) {
      if (g.inDegree[i] == 0) {
        q.add(i);
      }
    }
    // read all independent course to see if they can cover all the rest
    for (; !q.isEmpty(); --numCourses) {
      //search for all adjacent node
      g.adjacent[q.poll()].stream()
        .filter(i -> (0 == --g.inDegree[i])) // if this is a outgoing node now
        .forEachOrdered(i -> q.add(i));
    }
    // we will read everything single course just right if there is a correct dependency graph
    return numCourses == 0;
  }

  private static class Graph {

    private final int[] inDegree;

    private final LinkedList<Integer>[] adjacent;

    public Graph(final int n) {
      this.inDegree = new int[n];
      this.adjacent = new LinkedList[n];

      for (int i = 0; i < this.adjacent.length; ++i) {
        this.adjacent[i] = new LinkedList<>();
      }
    }

    public void addEdge(final int from, final int to) {
      ++this.inDegree[to];
      this.adjacent[from].add(to);
    }
  }
}
