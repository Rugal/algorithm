package ga.rugal.amazon.binarytreemaximumpathsum;

import ga.rugal.amazon.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum
 *
 * @author rugalbernstein
 */
public class Solution {

  private int maxValue;

  /**
   * A path from start to end, goes up on the tree for 0 or more steps, then goes down for 0 or more
   * steps. Once it goes down, it can't go up. Each path has a highest node, which is also the
   * lowest common ancestor of all other nodes on the path.<BR>
   *
   * A recursive method maxPathDown(TreeNode node) (1) computes the maximum path sum with highest
   * node is the input node, update maximum if necessary (2) returns the maximum sum of the path
   * that can be extended to input node's parent.
   *
   * @param root
   *
   * @return
   */
  public int maxPathSum(final TreeNode root) {
    maxValue = Integer.MIN_VALUE;
    this.maxPathDown(root);
    return maxValue;
  }

  private int maxPathDown(final TreeNode node) {
    if (node == null) {
      return 0;
    }
    final int left = Math.max(0, this.maxPathDown(node.left));
    final int right = Math.max(0, this.maxPathDown(node.right));
    this.maxValue = Math.max(this.maxValue, left + right + node.val);
    return Math.max(left, right) + node.val;
  }
}
