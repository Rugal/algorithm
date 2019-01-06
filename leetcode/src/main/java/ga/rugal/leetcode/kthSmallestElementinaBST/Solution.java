package ga.rugal.leetcode.kthSmallestElementinaBST;

import ga.rugal.leetcode.TreeNode;

/**
 *
 * @author Rugal Bernstein
 */
public class Solution {

  private int count = 0;

  private int kcount = 0;

  public int kthSmallest(final TreeNode root, final int k) {
    this.count = 0;
    this.kcount = k;
    final TreeNode in = this.inorder(root);
    return in == null
           ? 0
           : in.val;
  }

  private TreeNode inorder(final TreeNode root) {
    if (root == null) {
      return null;
    }

    final TreeNode left = this.inorder(root.left);
    if (left != null) {
      return left;
    }
    if (++this.count == this.kcount) {
      return root;
    }
    return this.inorder(root.right);
  }
}
