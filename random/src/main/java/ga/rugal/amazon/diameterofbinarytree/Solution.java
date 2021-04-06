package ga.rugal.amazon.diameterofbinarytree;

import ga.rugal.amazon.TreeNode;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
 *
 * @author rugal
 */
public class Solution {

  private int max = 0;

  public int diameterOfBinaryTree(final TreeNode root) {
    this.maxDepth(root);
    return this.max;
  }

  private int maxDepth(final TreeNode node) {
    if (null == node) {
      return 0;
    }
    // get max from left
    final int left = this.maxDepth(node.left);
    // get max from right
    final int right = this.maxDepth(node.right);
    // update max on the go
    this.max = Math.max(this.max, left + right);

    return Math.max(left, right) + 1;
  }
}
