package ga.rugal.leetcode.kthSmallestElementinaBST;

import ga.rugal.leetcode.TreeNode;

/**
 *
 * @author Rugal Bernstein
 */
public class Solution {

  private int count = 0;

  private int kcount = 0;

  /**
   * Inorder traversal can find k smallest element in tree in the most efficient way.<BR>
   *
   * @param root
   * @param k
   *
   * @return
   */
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
    //by recursion, it will go down to the very bottom left first
    final TreeNode left = this.inorder(root.left);
    if (left != null) {
      return left;
    }
    //then start to count from bottom left
    if (++this.count == this.kcount) {
      return root;
    }
    return this.inorder(root.right);
  }
}
