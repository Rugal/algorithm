package ga.rugal.hacker;

/**
 * 3. Given a binary tree, find the level which has maximum number of nodes, consider root as level
 * zero
 *
 * http://www.geeksforgeeks.org/maximum-width-of-a-binary-tree/
 *
 * @author Rugal Bernstein
 */
public class MaxNodeLevel
{

    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(8);
        tree.root.right.right.left = new Node(6);
        tree.root.right.right.right = new Node(7);
        System.out.println("Maximum width is " + tree.getMaxWidth(tree.root));
    }
}

// Java program to calculate width of binary tree
// A binary tree node
class Node
{

    int data;

    Node left, right;

    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}

class BinaryTree
{

    Node root;

    /* Function to get the maximum width of a binary tree*/
    int getMaxWidth(Node node)
    {
        int width;
        int h = height(node);

        // Create an array that will store count of nodes at each level
        int count[] = new int[10];

        int level = 0;

        // Fill the count array using preorder traversal
        getMaxWidthRecur(node, count, level);

        // Return the maximum value from count array
        return getMax(count, h);
    }

    // A function that fills count array with count of nodes at every
    // level of given binary tree
    void getMaxWidthRecur(Node node, int count[], int level)
    {
        if (node != null)
        {
            count[level]++;
            getMaxWidthRecur(node.left, count, level + 1);
            getMaxWidthRecur(node.right, count, level + 1);
        }
    }

    /* Function to get the maximum width of a binary tree*/
    int getMaxWidthLiner(Node node)
    {
        int maxWidth = 0;
        int width;
        int h = height(node);
        int i;
        /* Get width of each level and compare
         the width with maximum width so far */
        for (i = 1; i <= h; i++)
        {
            width = getWidth(node, i);
            if (width > maxWidth)
            {
                maxWidth = width;
            }
        }
        return maxWidth;
    }

    /* Get width of a given level */
    int getWidth(Node node, int level)
    {
        if (node == null)
        {
            return 0;
        }
        if (level == 1)
        {
            return 1;
        }
        if (level > 1)
        {
            return getWidth(node.left, level - 1) + getWidth(node.right, level - 1);
        }
        return 0;
    }
    // Return the maximum value from count array

    int getMax(int arr[], int n)
    {
        int max = arr[0];
        int i;
        for (i = 0; i < n; i++)
        {
            if (arr[i] > max)
            {
                max = arr[i];
            }
        }
        return max;
    }


    /* UTILITY FUNCTIONS */
 /* Compute the "height" of a tree -- the number of
     nodes along the longest path from the root node
     down to the farthest leaf node.*/
    int height(Node node)
    {
        if (node != null)
        {
            /* compute the height of each subtree */
            int lHeight = height(node.left) + 1;
            int rHeight = height(node.right) + 1;
            /* use the larger one */
            return (lHeight > rHeight) ? lHeight : rHeight;
        }
        return 0;
    }

}
