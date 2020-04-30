package ga.rugal.leetcode.checkvalidstringintree;

import ga.rugal.leetcode.TreeNode;

/**
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/532/week-5/3315/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  private int[] array;

  public boolean isValidSequence(final TreeNode root, final int[] arr) {
    this.array = arr;
    return this.isValid(root, 0);
  }

  private boolean isValid(final TreeNode root, final int index) {
    if (null == root || root.val != this.array[index]) {
      return false;
    }
    if (index == this.array.length - 1) {
      return null == root.left && null == root.right;
    }
    if (null == root.left && null == root.right) {
      return index == this.array.length - 1;
    }
    return this.isValid(root.left, index + 1) || this.isValid(root.right, index + 1);
  }
}
