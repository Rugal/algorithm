package ga.rugal.leetcode.lowestcommonancestorofabinarytree;

import ga.rugal.leetcode.TreeNode;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  private TreeNode result;

  private boolean test(final TreeNode current, final TreeNode p, final TreeNode q) {
    if (null == current) {
      return false;
    }
    final int left = this.test(current.left, p, q) ? 1 : 0;
    final int right = this.test(current.right, p, q) ? 1 : 0;
    final int mid = (current == p || current == q) ? 1 : 0;
    final int count = left + mid + right;
    if (count > 1) {
      //if has 2 sides match
      this.result = current;
    }
    //any side matches
    return count > 0;
  }

  public TreeNode lowestCommonAncestor(final TreeNode root, final TreeNode p, final TreeNode q) {
    this.test(root, p, q);
    return this.result;
  }
}
