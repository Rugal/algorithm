package ga.rugal.amazon.lowestcommonancestorofabinarytree;

import ga.rugal.amazon.TreeNode;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  private TreeNode result;

  public TreeNode lowestCommonAncestor(final TreeNode root, final TreeNode p, final TreeNode q) {
    this.test(root, p, q);
    return this.result;
  }

  private boolean test(final TreeNode root, final TreeNode p, final TreeNode q) {
    if (null == root) {
      return false;
    }
    // if any node is the current node
    final int mid = (p == root || q == root) ? 1 : 0;
    // if any node is at left tree
    final int left = this.test(root.left, p, q) ? 1 : 0;
    // if any node is at right tree
    final int right = this.test(root.right, p, q) ? 1 : 0;
    final int count = mid + left + right;
    if (count > 1) {
      // if more than 1 node occurred here
      this.result = root;
    }
    return count > 0;
  }
}
