package ga.rugal.amazon.twosumivinputisabst;

import java.util.HashSet;
import java.util.Set;

import ga.rugal.amazon.TreeNode;

/**
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 *
 * @author rugalbernstein
 */
public class Solution {

  private final Set<Integer> set = new HashSet<>();

  private int k;

  public boolean findTarget(final TreeNode root, final int k) {
    this.k = k;
    return this.inorder(root);
  }

  /**
   * The rationale behind is,, inorder traverse would traverse in ascending order. By doing so, we
   * check value in ascending order, so that we always go through everything.<BR>
   *
   * @param root
   *
   * @return
   */
  private boolean inorder(final TreeNode root) {
    if (null == root) {
      return false;
    }
    // if result in left or in current node
    if (this.inorder(root.left) // traverse all the way to bottom left
        || this.set.contains(this.k - root.val)) { // now we have found both a + b = k
      return true;
    }
    // if not found at all, add the current value
    this.set.add(root.val);
    // then traverse to the right
    return this.inorder(root.right);
  }
}
