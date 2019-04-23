package ga.rugal.lintcode.amazon.binarytreelevelordertraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import ga.rugal.lintcode.TreeNode;

/**
 * https://www.lintcode.com/problem/binary-tree-level-order-traversal/description
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

  public List<List<Integer>> levelOrder2(final TreeNode root) {
    if (null == root) {
      return this.lists;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      final int size = queue.size();
      final List<Integer> list = new ArrayList<>();
      for (int i = 0; i < size; ++i) {
        final TreeNode poll = queue.poll();
        list.add(poll.val);
        if (poll.left != null) {
          queue.offer(poll.left);
        }
        if (poll.right != null) {
          queue.offer(poll.right);
        }
      }
      this.lists.add(list);
    }

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
