package ga.rugal.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * An Java implementation of AVL tree.<BR>
 * Inspired by http://www.geeksforgeeks.org/avl-tree-set-1-insertion/
 *
 * @author Rugal Bernstein
 * @param <K>
 * @param <V>
 *
 */
public class AVLTree<K extends Comparable, V> implements Tree<K, V> {

  private static final Logger LOG = LoggerFactory.getLogger(AVLTree.class.getName());

  private int size = 0;

  private TreeNode<K, V> root = null;

  public AVLTree() {
  }

  /**
   * Rotate a tree to right. The given node A becomes right subtree of its origin left tree B.<BR>
   * The B node becomes parent of A .<BR>
   * The origin right tree C of B becomes new left tree of A.<BR>
   *       6
   *      / \
   *     3   8
   *    / \
   *   2   5
   *  /
   * 1
   * 
   * --->
   * 
   *     3
   *    / \
   *   2   6
   *  /   / \
   * 1   5   8

   * @param node
   *
   * @return The new parent node that hold given node.
   */
  private TreeNode rightRotate(final TreeNode node) {
    final TreeNode newParent = node.left;
    final TreeNode originRight = newParent.right;
    // Perform rotation
    newParent.right = node;
    node.left = originRight;
    // Update heights
    node.height = Math.max(height(node.left), height(node.right)) + 1;
    newParent.height = Math.max(height(newParent.left), height(newParent.right)) + 1;
    // Return new root
    return newParent;
  }

  /**
   * Rotate a tree to left. The given node A becomes left subtree of its origin right tree B.<BR>
   * The origin right tree node C becomes parent of A.<BR>
   * The origin left tree C of B becomes new right tree of A .<BR>
   *   3
   *  / \
   * 1   6
   *    / \
   *   5   7
   *        \
   *         9  
   * 
   * --->
   * 
   *      6
   *     / \
   *    3   7
   *   / \   \
   *  1   5   9
   *
   * @param node
   *
   * @return The new parent node that hold given node.
   */
  private TreeNode leftRotate(TreeNode node) {
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
   * See if current node is balance.
   *
   * @param node return 0 if given node is null.
   *
   * @return 0 if balance; otherwise indicates the difference between left and right tree.
   */
  private int getBalance(TreeNode node) {
    return null != node ? this.height(node.left) - this.height(node.right) : 0;
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
  private int height(TreeNode node) {
    return null != node ? node.height : -1;
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
  private TreeNode<K, V> insert(final TreeNode<K, V> node, final K key, final V value) {
    /*
     * 1. Perform the normal BST rotation
     */
    if (null == node) {
      this.size++;
      return new TreeNode<>(key, value);
    }
    final int result = key.compareTo(node.getKey());
    if (0 == result) {
      //replace an existed value, no need for structure re-adjust
      node.setValue(value);
      return node;
    }
    if (result < 0) {
      node.left = insert(node.left, key, value);
    } else {
      node.right = insert(node.right, key, value);
    }
    /*
     * 2. Update height of this ancestor node recursively
     */
    node.height = Math.max(height(node.left), height(node.right)) + 1;

    /*
     * 3. Get the balance factor of this ancestor node to check whether this node became unbalanced
     */
    final int balance = getBalance(node);

    // If this node becomes unbalanced, then there are 4 cases
    // Left Left Case
    if (balance > 1 && key.compareTo(node.left.getKey()) < 0) {
      return rightRotate(node);
    }

    // Right Right Case
    if (balance < -1 && key.compareTo(node.right.getKey()) > 0) {
      return leftRotate(node);
    }

    // Left Right Case
    if (balance > 1 && key.compareTo(node.left.getKey()) > 0) {
      node.left = leftRotate(node.left);
      return rightRotate(node);
    }

    // Right Left Case
    if (balance < -1 && key.compareTo(node.right.getKey()) < 0) {
      node.right = rightRotate(node.right);
      return leftRotate(node);
    }
    /*
     * return the (unchanged) node pointer
     */
    return node;
  }

  /**
   * {@inheritDoc }
   */
  @Override
  public void put(K key, V value) {
    this.root = this.insert(root, key, value);
  }

  /**
   * {@inheritDoc }
   */
  @Override
  public V get(final K key) {
    if (null == key || this.isEmpty()) {
      return null;
    }
    TreeNode<K, V> temp = root;
    while (null != temp) {
      final int result = temp.getKey().compareTo(key);
      if (0 == result) {
        return temp.getValue();
      }
      temp = result < 0 ? temp.right: temp.left;
    }
    return null;
  }

  private TreeNode<K, V> deleteNode(TreeNode<K, V> node, K key) {
    // STEP 1: PERFORM STANDARD BST DELETE
    if (null == node) {
      return node;
    }
    int result = key.compareTo(node.getKey());
    // if key is same as root's key, then This is the node to be deleted
    if (0 == result) {
      // node with only one child or no child
      if ((node.left == null) || (node.right == null)) {
        TreeNode<K, V> temp = node.left != null ? node.left : node.right;
        // No child case
        if (temp == null) {
          // temp = node;
          node = null;
        } else // One child case
        {
          // Copy the contents of the non-empty child
          node = temp;
        }
      } else {
        // node with two children: Get the inorder successor (smallest
        // in the right subtree)
        TreeNode<K, V> temp = minValueNode(node.right);
        // Copy the inorder successor's data to this node
        node.setKey(temp.getKey());
        node.setValue(temp.getValue());
        // Delete the inorder successor
        node.right = deleteNode(node.right, temp.getKey());
      }
    } else {
      if (key.compareTo(node.getKey()) < 0) {
        // If the key to be deleted is smaller than the root's key,
        // then it lies in left subtree
        node.left = deleteNode(node.left, key);
      } else {
        // If the key to be deleted is greater than the root's key,
        // then it lies in right subtree
        node.right = deleteNode(node.right, key);
      }
    }

    // If the tree had only one node then return
    if (node == null) {
      return node;
    }
    // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
    node.height = Math.max(height(node.left), height(node.right)) + 1;

    // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
    //  this node became unbalanced)
    int balance = getBalance(node);

    // If this node becomes unbalanced, then there are 4 cases
    // Left Left Case
    if (balance > 1 && getBalance(node.left) >= 0) {
      return rightRotate(node);
    }

    // Left Right Case
    if (balance > 1 && getBalance(node.left) < 0) {
      node.left = leftRotate(node.left);
      return rightRotate(node);
    }

    // Right Right Case
    if (balance < -1 && getBalance(node.right) <= 0) {
      return leftRotate(node);
    }

    // Right Left Case
    if (balance < -1 && getBalance(node.right) > 0) {
      node.right = rightRotate(node.right);
      return leftRotate(node);
    }
    return node;
  }

  /**
   * {@inheritDoc }
   */
  @Override
  public boolean remove(K key) {
    if (null == key || this.isEmpty() || !this.containsKey(key)) {
      return false;
    }
    root = this.deleteNode(root, key);
    this.size--;
    return true;
  }

  /**
   * Given a non-empty binary search tree, return the node with minimum key value found in that
   * tree. Note that the entire tree does not need to be searched.
   */
  private TreeNode<K, V> minValueNode(TreeNode<K, V> node) {
    TreeNode<K, V> current = node;
    /*
     * loop down to find the leftmost leaf
     */
    while (null != current.left) {
      current = current.left;
    }
    return current;
  }

  /**
   * {@inheritDoc }
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * {@inheritDoc }
   */
  @Override
  public boolean isEmpty() {
    return this.size() == 0;
  }

  /**
   * {@inheritDoc }
   */
  @Override
  public boolean containsKey(K key) {
    return this.get(key) != null;
  }

  /**
   * {@inheritDoc }
   */
  @Override
  public void clear() {
    this.root = null;
    this.size = 0;
  }

  private List<K> preOrder() {
    Stack<TreeNode> stack = new Stack<>();
    List<K> list = new ArrayList<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode<K, V> node = stack.pop();
      list.add(node.getKey());
      if (null != node.right) {
        stack.push(node.right);
      }
      if (null != node.left) {
        stack.push(node.left);
      }
    }
    return list;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    preOrder().stream().forEach((k)
      -> {
      sb.append(k).append(" ");
    });
    return sb.toString();
  }

}
