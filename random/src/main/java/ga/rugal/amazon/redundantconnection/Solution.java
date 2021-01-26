package ga.rugal.amazon.redundantconnection;

/**
 * https://leetcode.com/problems/redundant-connection/
 *
 * @author rugalbernstein
 */
public class Solution {

  public int[] findRedundantConnection(final int[][] edges) {
    final UnionFindSet set = new UnionFindSet(edges.length);
    for (int[] edge : edges) {
      // keep union all edges until there is a cycle
      // the one that makes up the cycle is the redundant connection
      if (!set.union(edge[0], edge[1])) {
        return edge;
      }
    }
    return null;
  }

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
      // if current element belongs to another group
      if (u != this.parent[u]) {
        // traverse all the way to the root and set as new root
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
      // get root for left and right
      final int x = this.find(left);
      final int y = this.find(right);
      if (x == y) {
        //no union need
        return false;
      }
      // put lower rank one to the higher one
      if (this.rank[y] > this.rank[x]) {
        // y has higher rank, set root of x as y
        this.parent[x] = y;
        return true;
      }
      // same applies here
      if (this.rank[y] < this.rank[x]) {
        this.parent[y] = x;
        return true;
      }
      // both have same rank, just set x as root of y
      this.parent[y] = x;
      // increment rank of x
      ++this.rank[x];
      return true;
    }
  }
}
