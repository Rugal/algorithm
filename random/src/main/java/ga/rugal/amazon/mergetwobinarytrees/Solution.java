package ga.rugal.amazon.mergetwobinarytrees;

import java.util.LinkedList;
import java.util.Queue;

import ga.rugal.amazon.TreeNode;

/**
 * https://leetcode.com/problems/merge-two-binary-trees/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) {
      return null;
    }
    if (t1 == null || t2 == null) {
      return t1 == null ? t2 : t1;
    }
    final Queue<Pair<TreeNode, TreeNode>> q = new LinkedList<>();
    q.offer(new Pair<>(t1, t2));
    while (!q.isEmpty()) {
      final Pair<TreeNode, TreeNode> pop = q.poll();
      // add to t1 tree
      pop.key.val += pop.value.val;
      if (pop.key.left != null || pop.value.left != null) {
        // process left tree of both tree
        // populate left and right Pair even if one of them is null
        pop.key.left = pop.key.left == null ? new TreeNode(0) : pop.key.left;
        pop.value.left = pop.value.left == null ? new TreeNode(0) : pop.value.left;
        // push to stack for process next time
        q.offer(new Pair(pop.key.left, pop.value.left));
      }
      if (pop.key.right != null || pop.value.right != null) {
        // process right tree of both tree
        // populate left and right Pair even if one of them is null
        pop.key.right = pop.key.right == null ? new TreeNode(0) : pop.key.right;
        pop.value.right = pop.value.right == null ? new TreeNode(0) : pop.value.right;
        // push to stack for process next time
        q.offer(new Pair(pop.key.right, pop.value.right));
      }
    }
    return t1;
  }
}

class Pair<KEY, VALUE> {

  public final KEY key;

  public final VALUE value;

  public Pair(KEY key, VALUE value) {
    this.key = key;
    this.value = value;
  }
}
