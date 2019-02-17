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

  public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) {
      return null;
    }
    if (t1 == null) {
      return t2;
    }
    if (t2 == null) {
      return t1;
    }
    Stack<Pair> stack = new Stack<>();
    stack.push(new Pair(t1, t2));
    while (!stack.isEmpty()) {
      final Pair pop = stack.pop();
      pop.key.val += pop.value.val;
      if (pop.key.left != null || pop.value.left != null) {
        pop.key.left = pop.key.left == null ? new TreeNode(0) : pop.key.left;
        pop.value.left = pop.value.left == null ? new TreeNode(0) : pop.value.left;
        stack.push(new Pair(pop.key.left, pop.value.left));
      }
      if (pop.key.right != null || pop.value.right != null) {
        pop.key.right = pop.key.right == null ? new TreeNode(0) : pop.key.right;
        pop.value.right = pop.value.right == null ? new TreeNode(0) : pop.value.right;
        stack.push(new Pair(pop.key.right, pop.value.right));
      }
    }
    return t1;
  }
}
