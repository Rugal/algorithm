package ga.rugal.leetcode.mergetwobinarytrees;

import java.util.Stack;

import ga.rugal.leetcode.TreeNode;

/**
 * https://leetcode.com/problems/merge-two-binary-trees/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  private static class Pair {

    public TreeNode key, value;

    public Pair(TreeNode left, TreeNode right) {
      this.key = left;
      this.value = right;
    }
  }

  public TreeNode mergeTrees(final TreeNode t1, final TreeNode t2) {
    if (t1 == null && t2 == null) {
      return null;
    }
    if (t1 == null) {
      return t2;
    }
    if (t2 == null) {
      return t1;
    }
    final Stack<Pair> stack = new Stack<>();
    stack.push(new Pair(t1, t2));
    while (!stack.isEmpty()) {
      final Pair pop = stack.pop();
      //combine value from two nodes into t1 tree node
      pop.key.val += pop.value.val;
      //if any left node is not null
      if (pop.key.left != null || pop.value.left != null) {
        //add dummy left node with 0 value if not exist
        pop.key.left = pop.key.left == null ? new TreeNode(0) : pop.key.left;
        pop.value.left = pop.value.left == null ? new TreeNode(0) : pop.value.left;
        stack.push(new Pair(pop.key.left, pop.value.left));
      }
      //if any right node is not null
      if (pop.key.right != null || pop.value.right != null) {
        //add dummy right node with 0 value if not exist
        pop.key.right = pop.key.right == null ? new TreeNode(0) : pop.key.right;
        pop.value.right = pop.value.right == null ? new TreeNode(0) : pop.value.right;
        stack.push(new Pair(pop.key.right, pop.value.right));
      }
    }
    return t1;
  }
}
