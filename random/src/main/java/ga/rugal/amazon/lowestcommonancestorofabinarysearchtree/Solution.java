package ga.rugal.amazon.lowestcommonancestorofabinarysearchtree;

import ga.rugal.amazon.TreeNode;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 *
 * @author rugal
 */
public class Solution {

  public TreeNode lowestCommonAncestor(final TreeNode root,
                                       final TreeNode p,
                                       final TreeNode q) {
    if ((p.val < root.val) && (q.val < root.val)) {
      // if both at left
      return this.lowestCommonAncestor(root.left, p, q);
    } else if ((p.val > root.val) && (q.val > root.val)) {
      // if both at right
      return this.lowestCommonAncestor(root.right, p, q);
    } else {
      // if this is the one
      return root;
    }
  }
}
