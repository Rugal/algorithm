package ga.rugal.leetcode.binarytreelevelordertraversal;

import java.util.ArrayList;
import java.util.List;

import ga.rugal.leetcode.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  private final List<List<Integer>> lists = new ArrayList<>();

  private int maxLevel = -1;

  public List<List<Integer>> levelOrder(TreeNode root) {
    this.levelTraverse(root, 0);
    return this.lists;
  }

  private void levelTraverse(final TreeNode root, final int level) {
    if (root == null) {
      return;
    }

    if (this.maxLevel < level) {
      //only the very first visit to the new level will be added
      this.maxLevel = level;
      this.lists.add(new ArrayList<>());
    }

    this.lists.get(level).add(root.val);
    this.levelTraverse(root.left, level + 1);
    this.levelTraverse(root.right, level + 1);
  }
}
