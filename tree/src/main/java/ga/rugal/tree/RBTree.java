package ga.rugal.tree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * http://www.geeksforgeeks.org/red-black-tree-set-1-introduction-2/
 *
 * @author Rugal Bernstein
 * @param <K>
 * @param <V>
 */
public class RBTree<K extends Comparable, V> implements Tree<K, V>
{

    private static final Logger LOG = LoggerFactory.getLogger(RBTree.class.getName());

    private int size = 0;

    private TreeNode<K, V> root = null;

    private boolean isBlack(TreeNode<K, V> node)
    {
        return node == null ? true : node.black;
    }

    /**
     * Recursive version of AVL tree insertion.
     *
     * @param node  the target node to be add on.
     * @param key
     * @param value
     *
     * @return
     */
    private TreeNode<K, V> insert(TreeNode<K, V> node, K key, V value)
    {
        /* 1.  Perform the normal BST rotation */
        if (null == node)
        {
            this.size++;
            return new TreeNode<>(key, value);
        }
        int result = key.compareTo(node.getKey());
        if (0 == result)
        {
            //replace an existed value, no need for structure re-adjust
            node.setValue(value);
            return node;
        }
        if (result < 0)
        {
            node.left = insert(node.left, key, value);
        } else
        {
            node.right = insert(node.right, key, value);
        }

        // fix-up any right-leaning links
        if (!isBlack(node.right) && isBlack(node.left))
        {
            node = leftRotate(node);
        }
        if (!isBlack(node.left) && !isBlack(node.left.left))
        {
            node = rightRotate(node);
        }
        if (!isBlack(node.left) && !isBlack(node.right))
        {
            flipColors(node);
        }
        return node;
    }

    @Override
    public void put(K key, V value)
    {
        root = this.insert(root, key, value);
        this.root.setBlack(this.size == 1);
    }

    @Override
    public V get(K key)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(K key)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size()
    {
        return this.size;
    }

    @Override
    public boolean isEmpty()
    {
        return this.size == 0;
    }

    @Override
    public boolean containsKey(K key)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void flipColors(TreeNode h)
    {
        // h must have opposite color of its two children
        // assert (h != null) && (h.left != null) && (h.right != null);
        // assert (!isRed(h) &&  isRed(h.left) &&  isRed(h.right))
        //    || (isRed(h)  && !isRed(h.left) && !isRed(h.right));
        h.black = !h.black;
        h.left.black = !h.left.black;
        h.right.black = !h.right.black;
    }

    /**
     * Rotate a tree to right. The given node becomes right subtree of its origin left tree.<BR>
     * The origin left tree node becomes parent of given node.<BR>
     * The origin right tree of origin left tree of given becomes new left tree of given tree.
     *
     * @param node
     *
     * @return The new parent node that hold given node.
     */
    private TreeNode rightRotate(TreeNode node)
    {
        TreeNode newParent = node.left;
        // Perform rotation
        node.left = newParent.right;
        newParent.right = node;
        // Update heights
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        newParent.height = Math.max(height(newParent.left), height(newParent.right)) + 1;
        // Return new root
        return newParent;
    }

    /**
     * Rotate a tree to left. The given node becomes left subtree of its origin right tree.<BR>
     * The origin right tree node becomes parent of given node.<BR>
     * The origin left tree of origin right tree of given becomes new right tree of given tree.
     *
     * @param node
     *
     * @return The new parent node that hold given node.
     */
    private TreeNode leftRotate(TreeNode node)
    {
        TreeNode newParent = node.right;
        TreeNode originLeft = newParent.left;
        // Perform rotation
        newParent.left = node;
        node.right = originLeft;
        //  Update heights
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        newParent.height = Math.max(height(newParent.left), height(newParent.right)) + 1;
        // Return new root
        return newParent;
    }

    /**
     * Get the height of a node.<BR>
     * The height of a node is the number of edges on the longest path from the node to a leaf. <BR>
     * A leaf node will have a height of 0.<BR>
     * The depth of a node is the number of edges from the node to the tree's root node. <BR>
     * A root node will have a depth of 0.
     *
     * @param node return -1 height if given node is null.
     *
     * @return
     */
    private int height(TreeNode node)
    {
        return null != node ? node.height : -1;
    }

}
