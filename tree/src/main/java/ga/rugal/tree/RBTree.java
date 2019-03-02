package ga.rugal.tree;

public class RBTree<Key extends Comparable<Key>, Value> implements Tree<Key, Value> {

  private TreeNode root = null;

  private int size = 0;

  private boolean isRed(TreeNode node) {
    return node == null ? false : node.red;
  }

  private boolean isBlack(TreeNode node) {
    return !this.isRed(node);
  }

  private TreeNode<Key, Value> insert(TreeNode<Key, Value> node, Key key, Value value) {
    if (null == node) {
      this.size++;
      return new TreeNode<>(key, value);
    }
    int result = key.compareTo(node.getKey());
    if (0 == result) {
      node.setValue(value);
      return node;
    }
    if (result < 0) {
      node.left = this.insert(node.left, key, value);
    } else {
      node.right = this.insert(node.right, key, value);
    }
    if (isRed(node.right) && isBlack(node.left)) {
      node = rotateLeft(node);
    }
    if (isRed(node.left) && isRed(node.left.left)) {
      node = rotateRight(node);
    }
    if (isRed(node.left) && isRed(node.right)) {
      flipColors(node);
    }
    return node;
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

  private void flipColors(TreeNode h) {
    // h must have opposite color of its two children
    // assert (h != null) && (h.left != null) && (h.right != null);
    // assert (!isRed(h) &&  isRed(h.left) &&  isRed(h.right))
    //    || (isRed(h)  && !isRed(h.left) && !isRed(h.right));
    h.red = !h.red;
    h.left.red = !h.left.red;
    h.right.red = !h.right.red;
  }

  private TreeNode rotateRight(TreeNode parent) {
    TreeNode newParent = parent.left;
    parent.left = newParent.right;
    newParent.right = parent;
    newParent.red = newParent.right.red;
    newParent.right.red = true;
    parent.height = Math.max(height(parent.left), height(parent.right)) + 1;
    newParent.height = Math.max(height(newParent.left), height(newParent.right)) + 1;
    return newParent;
  }

  // make a right-leaning link lean to the left
  private TreeNode rotateLeft(TreeNode parent) {
    TreeNode newParent = parent.right;
    parent.right = newParent.left;
    newParent.left = parent;
    newParent.red = newParent.left.red;
    newParent.left.red = true;
    parent.height = Math.max(height(parent.left), height(parent.right)) + 1;
    newParent.height = Math.max(height(newParent.left), height(newParent.right)) + 1;
    return newParent;
  }

  @Override
  public void put(Key key, Value value) {
    this.root = this.insert(root, key, value);
    this.root.red = false;
  }

  @Override
  public Value get(Key key) {
    if (null == root) {
      return null;
    }
    for (TreeNode<Key, Value> node = root; null != node;) {
      int result = key.compareTo(node.getKey());
      if (0 == result) {
        return node.getValue();
      }
      node = (result < 0) ? node.left : node.right;
    }
    return null;
  }

  @Override
  public boolean remove(Key key) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public int size() {
    return this.size;
  }

  @Override
  public boolean isEmpty() {
    return this.size == 0;
  }

  @Override
  public boolean containsKey(Key key) {
    return this.get(key) != null;
  }

  @Override
  public void clear() {
    this.root = null;
    this.size = 0;
  }

}
