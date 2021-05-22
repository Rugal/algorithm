package ga.rugal.wish.findleavesofbinarytree;

import java.util.ArrayList;
import java.util.List;

import ga.rugal.amazon.TreeNode;

/**
 * https://www.lintcode.com/problem/650/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  private List<List<Integer>> result;

  /**
   * @param root the root of binary tree @return: collect and remove all leaves
   *
   * @return
   */
  public List<List<Integer>> findLeaves(final TreeNode root) {
    this.result = new ArrayList<>();
    this.height(root);
    return this.result;
  }

  private int height(TreeNode root) {
    if (null == root) {
      return -1;
    }
    final int height = 1 + Math.max(this.height(root.left), this.height(root.right));
    if (height >= this.result.size()) {
      this.result.add(new ArrayList<>());
    }
    this.result.get(height).add(root.val);
    return height;
  }
}
