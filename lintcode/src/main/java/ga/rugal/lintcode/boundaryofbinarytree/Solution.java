package ga.rugal.lintcode.boundaryofbinarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import ga.rugal.lintcode.TreeNode;

/**
 * https://www.lintcode.com/problem/878/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  private List<Integer> getLeft(final TreeNode root) {
    final List<Integer> list = new ArrayList<>();
    list.add(root.val);
    if (null == root.left) {
      return list;
    }
    for (TreeNode n = root.left; null != n;) {
      list.add(n.val);
      if (null != n.left) {
        n = n.left;
        continue;
      }
      n = n.right;
    }
    // remove the left most leave
    if (list.size() > 1) {
      list.remove(list.size() - 1);
    }
    return list;
  }

  private List<Integer> getLeaves(final TreeNode root) {
    final List<Integer> list = new ArrayList<>();
    final Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      final TreeNode pop = stack.pop();

      if (null == pop.left && null == pop.right) {
        // it is leave
        list.add(pop.val);
        continue;
      }
      if (null != pop.right) {
        stack.push(pop.right);
      }
      if (null != pop.left) {
        stack.push(pop.left);
      }
    }
    return list;
  }

  private List<Integer> getRight(final TreeNode root) {
    final List<Integer> list = new ArrayList<>();
    if (null == root.right) {
      return list;
    }
    list.add(root.val);
    for (TreeNode n = root.right; null != n;) {
      list.add(n.val);
      if (null != n.right) {
        n = n.right;
        continue;
      }
      n = n.left;
    }
    if (list.size() > 1) {
      // remove the right most leave
      list.remove(list.size() - 1);
      // remove root
      list.remove(0);
    }
    // counter-clockwise
    Collections.reverse(list);
    return list;
  }

  /**
   * @param root: a TreeNode
   *
   * @return a list of integer
   */
  public List<Integer> boundaryOfBinaryTree(final TreeNode root) {
    if (null == root) {
      return new ArrayList<>();
    }
    final List<Integer> result = this.getLeft(root);
    result.addAll(this.getLeaves(root));
    result.addAll(this.getRight(root));
    return result;
  }
}
