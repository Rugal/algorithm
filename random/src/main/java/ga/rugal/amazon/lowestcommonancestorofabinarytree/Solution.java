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

  private boolean test(final TreeNode current, final TreeNode p, final TreeNode q) {
    if (null == current) {
      return false;
    }
    // if any node is the current node
    final int mid = (p == current || q == current) ? 1 : 0;
    // if any node is at left tree
    final int left = this.test(current.left, p, q) ? 1 : 0;
    // if any node is at right tree
    final int right = this.test(current.right, p, q) ? 1 : 0;
    final int count = mid + left + right;
    if (count >= 2) {
      // if both node root at current node
      this.result = current;
    }
    return count > 0;
  }
}
