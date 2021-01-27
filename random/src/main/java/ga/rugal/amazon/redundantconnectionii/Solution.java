package ga.rugal.amazon.redundantconnectionii;

/**
 * https://leetcode.com/problems/redundant-connection-ii/
 *
 * @author rugalbernstein
 */
public class Solution {

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

  /**
   * Case 1: No duplicate parent<BR>
   * [[1, 2], [2, 3], [3, 1]] or [[1, 2], [2, 3], [3, 4], [4, 1]]<BR>
   * This is the same problem as the original question. Simply use UnionSet to find the last path
   * that cause circle<BR>
   *
   * Case 2: Has duplicate parent<BR>
   * Case 2.1: No circle<BR>
   * [[1, 2], [2, 3], [1, 3]]<BR>
   * Remove any one of the edge satisfy the question. Just remove the last edge.<BR>
   * Case 2.2: Has circle<BR>
   * [[1, 2], [2, 3], [3, 1], [4, 1]]<BR>
   * In this case, we remove the last edge that creates the circle, which is [3, 1]
   *
   * @param edges
   *
   * @return
   */
  public int[] findRedundantDirectedConnection(final int[][] edges) {
    final var parentEdge = new int[2];
    final var deletedEdge = new int[2];
    this.removeDuplicateParent(edges, parentEdge, deletedEdge);

    // Union Find Set is not directed, it only knows who belongs to where
    final var set = new UnionFindSet(edges.length);
    for (var edge : edges) {
      if (edge[0] < 0 || edge[1] < 0) {
        // Skip this edge as it was deleted
        continue;
      }
      // since we already deleted the second edge
      // so the edge that forms the circle must be the parentEdge or current
      // whether it is the parentEdge or current is depending on the duplication detection that we did before
      if (set.find(edge[0]) == set.find(edge[1])) {
        return parentEdge[0] == 0
               ? new int[]{edge[0], edge[1]} // case   1: no duplication
               : parentEdge;                 // case 2.2: duplicate but no circle
      }
      set.union(edge[0], edge[1]);
    }
    // case 2.1: no circle detected because we deleted one edge
    // so the edge deleted is the answer
    return deletedEdge;
  }

  /**
   * Detect duplicate parent edge in graph.<BR>
   * Keep the first edge that forms the duplication, but delete the second one.<BR>
   *
   * @param edges
   * @param parentEdge
   * @param deleteEdge
   */
  private void removeDuplicateParent(final int[][] edges,
                                     final int[] parentEdge,
                                     final int[] deleteEdge) {
    // Possible two edges to same parent in cases 2.
    final int[] parent = new int[edges.length + 1];
    for (int[] edge : edges) {
      // save current edge
      final int from = edge[0];
      final int to = edge[1];
      // there is duplicate parents
      if (parent[to] > 0) {
        // another edge that ends at <to> that comes before current edge
        parentEdge[0] = parent[to];
        parentEdge[1] = to;
        // Add 2nd edge somewhere because we are going to delete them
        deleteEdge[0] = from;
        deleteEdge[1] = to;
        // Delete the 2nd edge
        edge[0] = -1;
        edge[1] = -1;
      }
      // set parent of <to> to <from>
      parent[to] = from;
    }
  }
}
