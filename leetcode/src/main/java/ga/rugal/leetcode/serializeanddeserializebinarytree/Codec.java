package ga.rugal.leetcode.serializeanddeserializebinarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import ga.rugal.leetcode.TreeNode;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 *
 * @author Rugal Bernstein
 */
public class Codec {

  private static final String NULL = "null";

  // Encodes a tree to a single string.
  public String serialize(final TreeNode root) {

    if (null == root) {
      return "";
    }

    final List<String> list = new ArrayList<>();
    final Deque<TreeNode> queue = new LinkedList<>();
    for (queue.add(root); !queue.isEmpty();) {
      final TreeNode current = queue.poll();
      if (null == current) {
        list.add(NULL);
        continue;
      }
      list.add("" + current.val);
      queue.add(current.left);
      queue.add(current.right);
    }

    return String.join(",", list);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data.isEmpty()) {
      return null;
    }
    final String[] split = data.split(",");
    final TreeNode root = new TreeNode(Integer.parseInt(split[0]));
    final Deque<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    boolean isLeft = true;
    for (int i = 1; i < split.length; ++i) {
      final String s = split[i];
      final TreeNode parent = queue.peek();
      if (isLeft) {
        if (!s.equals(NULL)) {
          parent.left = new TreeNode(Integer.parseInt(s));
          queue.add(parent.left);
        }
        isLeft = false;
      } else {
        if (!s.equals(NULL)) {
          parent.right = new TreeNode(Integer.parseInt(s));
          queue.add(parent.right);
        }
        isLeft = true;
        queue.poll();
      }
    }

    return root;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
