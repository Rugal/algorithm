package ga.rugal.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-paths/?tab=Description
 *
 * @author rugal
 */
public class BinaryTreePaths {

    private final List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (null == root) {
            return this.result;
        }
        this.recursive(root, "");
        return this.result;
    }

    private void recursive(TreeNode root, String current) {
        if (null == root) {
            return;
        }
        String next = (current.isEmpty() ? "" : current + "->") + root.val;
        this.recursive(root.left, next);
        this.recursive(root.right, next);
        if (null == root.left && null == root.right) {
            this.result.add(next);
        }
    }
}
