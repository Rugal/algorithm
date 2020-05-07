package ga.rugal.leetcode.cousinsinbinarytree;

import java.util.LinkedList;
import java.util.Queue;

import ga.rugal.leetcode.TreeNode;

/**
 * https://leetcode.com/problems/cousins-in-binary-tree/
 *
 * @author rugal
 */
public class Solution {

  public boolean isCousins(TreeNode root, int x, int y) {
    final Pair pa = this.getPair(root, x);
    final Pair pb = this.getPair(root, y);
    return pa.parent != pb.parent && pa.height == pb.height;
  }

  private Pair getPair(final TreeNode root, final int target) {
    final Queue<Pair> q = new LinkedList<>();
    q.offer(new Pair(null, root, 0));
    while (!q.isEmpty()) {
      final Pair p = q.poll();
      if (p.current.val == target) {
        return p;
      }
      if (null != p.current.left) {
        q.offer(new Pair(p.current, p.current.left, p.height + 1));
      }
      if (null != p.current.right) {
        q.offer(new Pair(p.current, p.current.right, p.height + 1));
      }
    }
    return null;
  }
}

class Pair {

  public Pair(TreeNode parent, TreeNode current, int height) {
    this.parent = parent;
    this.current = current;
    this.height = height;
  }

  public TreeNode parent;

  public TreeNode current;

  public int height;
}
