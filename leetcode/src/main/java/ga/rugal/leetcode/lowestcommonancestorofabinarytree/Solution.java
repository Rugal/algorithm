package ga.rugal.leetcode.lowestcommonancestorofabinarytree;

import ga.rugal.leetcode.TreeNode;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  private TreeNode result;

  private TreeNode p;

  private TreeNode q;

  private boolean dfs(final TreeNode current) {
    if (null == current) {
      return false;
    }
    final int mid = (current == p || current == q) ? 1 : 0;//data source
    final int left = this.dfs(current.left) ? 1 : 0;
    final int right = this.dfs(current.right) ? 1 : 0;
    final int count = left + mid + right;
    if (count > 1) {//this is key, if has 2 sides match
      /*
       * in all cases, setting O as result will give us the correct answer
       *  O
       * / \
       *p+  q+
       *
       *  O+
       * / \
       *p   q+
       *
       *  O+
       * / \
       *p+  q
       */
      //but it wont if only 1 node matches, because the parent of result could also match 1 node,
      //either left or right matches, so this will mistakenly update the result to its parent
      this.result = current;
    }
    //any side matches
    return count > 0;
  }

  public TreeNode lowestCommonAncestor(final TreeNode root, final TreeNode p, final TreeNode q) {
    this.p = p;
    this.q = q;
    this.dfs(root);
    return this.result;
  }
}
