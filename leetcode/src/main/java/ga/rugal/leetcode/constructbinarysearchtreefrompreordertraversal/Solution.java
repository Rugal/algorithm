package ga.rugal.leetcode.constructbinarysearchtreefrompreordertraversal;

import ga.rugal.leetcode.TreeNode;

/**
 * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 *
 * @author rugal
 */
public class Solution {

  public TreeNode bstFromPreorder(final int[] preorder) {
    return this.build(preorder, 0, preorder.length - 1);
  }

  private TreeNode build(final int[] array, final int left, final int right) {
    if (left > right) {
      return null;
    }
    final TreeNode node = new TreeNode(array[left]);
    int mid;
    for (mid = left; mid <= right; ++mid) {
      if (array[mid] > node.val) {
        break;
      }
    }
    node.left = this.build(array, left + 1, mid - 1);
    node.right = this.build(array, mid, right);
    return node;
  }
}
