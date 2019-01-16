package ga.rugal.leetcode.binarytreerightsideview;

import java.util.ArrayList;
import java.util.List;

import ga.rugal.leetcode.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  private int maxLevel = -1;

  final List<Integer> result = new ArrayList<>();

  public List<Integer> rightSideView(final TreeNode root) {

    if (null == root) {
      return this.result;
    }
    this.levelTraverse(root, 0);
    return this.result;
  }

  private void levelTraverse(final TreeNode root, final int level) {
    if (root == null) {
      return;
    }

    if (this.maxLevel < level) {
      //only the very first visit to the new level will be added
      this.maxLevel = level;
      this.result.add(root.val);
    }
    //start with right
    this.levelTraverse(root.right, level + 1);
    this.levelTraverse(root.left, level + 1);
  }
}
