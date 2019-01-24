package ga.rugal.leetcode.mergetwobinarytrees;

import java.util.Stack;

import ga.rugal.leetcode.TreeNode;

import javafx.util.Pair;

/**
 * https://leetcode.com/problems/merge-two-binary-trees/
 *
 * @author Rugal Bernstein
 */
public class Solution {

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
    Stack<Pair<TreeNode, TreeNode>> stack = new Stack<>();
    stack.push(new Pair<>(t1, t2));
    while (!stack.isEmpty()) {
      final Pair<TreeNode, TreeNode> pop = stack.pop();
      pop.getKey().val += pop.getValue().val;
      if (pop.getKey().left != null || pop.getValue().left != null) {
        pop.getKey().left = pop.getKey().left == null ? new TreeNode(0) : pop.getKey().left;
        pop.getValue().left = pop.getValue().left == null ? new TreeNode(0) : pop.getValue().left;
        stack.push(new Pair(pop.getKey().left, pop.getValue().left));
      }
      if (pop.getKey().right != null || pop.getValue().right != null) {
        pop.getKey().right = pop.getKey().right == null ? new TreeNode(0) : pop.getKey().right;
        pop.getValue().right = pop.getValue().right == null ? new TreeNode(0) : pop.getValue().right;
        stack.push(new Pair(pop.getKey().right, pop.getValue().right));
      }
    }
    return t1;
  }
}
