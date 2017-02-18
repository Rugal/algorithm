package ga.rugal.leetcode;

import java.util.Stack;

/**
 *
 * @author Rugal Bernstein
 */
public class SCAofBST
{

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        Stack<TreeNode> stackp = this.pathToNode(root, p);
        Stack<TreeNode> stackq = this.pathToNode(root, q);
        int length = stackp.size() < stackq.size() ? stackp.size() : stackq.size();
        int index;
        for (index = 0; index < length; index++)
        {
            if (stackp.get(index).val != stackq.get(index).val)
            {
                break;
            }
        }
        return stackp.get(index > 0 ? index - 1 : index);
    }

    private Stack<TreeNode> pathToNode(TreeNode root, TreeNode target)
    {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (stack.peek().val != target.val)
        {
            TreeNode temp = stack.peek();
            if (temp.val > target.val)
            {
                temp = temp.left;
            } else
            {
                temp = temp.right;
            }
            stack.push(temp);
        }
        return stack;
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);

        SCAofBST bst = new SCAofBST();
        bst.lowestCommonAncestor(root, new TreeNode(1), new TreeNode(2));
    }
}
