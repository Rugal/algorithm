package ga.rugal.amazon.shoppingpatterns;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://aonecode.com/amazon-online-assessment-shopping-patterns
 * https://www.youtube.com/watch?v=EdJhwAhVFXY&ab_channel=YetanotherAggie
 *
 * @author rugal
 */
public class Solution {

  private Set<Integer>[] build(final int n, final List<Integer[]> edges) {
    final Set<Integer>[] graph = new HashSet[n + 1];
    for (var edge : edges) {
      // instantiate set if not done yet
      if (null == graph[edge[0]]) {
        graph[edge[0]] = new HashSet<>();
      }
      if (null == graph[edge[1]]) {
        graph[edge[1]] = new HashSet<>();
      }
      // undirected connection
      graph[edge[0]].add(edge[1]);
      graph[edge[1]].add(edge[0]);
    }
    return graph;
  }

  /**
   * Get minimum score of all trios in this product graph.
   *
   * @param n     number of node,
   * @param edges Undirected connection from X to Y, 1 based index
   *
   * @return
   */
  public int getMinScore(final int n, final List<Integer[]> edges) {
    final Set<Integer>[] G = this.build(n, edges);
    int result = Integer.MAX_VALUE;
    for (int i = 1; i < G.length; ++i) {
      // if node that has trio potential
      if (G[i].size() < 2) {
        continue;
      }
      // it has trio potential
      // verify if it is indeed a trio
      final var neighbours = new ArrayList<>(G[i]);
      // get one neighbour
      for (int j = 0; j < neighbours.size(); ++j) {
        // see if it actually connects with other neighbour
        final var a = neighbours.get(j);
        for (int k = j + 1; j < neighbours.size(); ++j) {
          // if our neighbour j does not connect with neighbour k
          final var b = neighbours.get(k);
          if (!G[a].contains(b)) {
            // this is not a trio
            continue;
          }
          // now verified it is a true trio, time to calculate the cost
          // each node would connect to 2 other nodes, so we have 6 invalid edge needs to be removed
          final int cost = G[i].size() + G[a].size() + G[b].size() - 6;
          result = Math.min(result, cost);
        }
      }
    }
    return result == Integer.MAX_VALUE ? -1 : result;
  }
}
