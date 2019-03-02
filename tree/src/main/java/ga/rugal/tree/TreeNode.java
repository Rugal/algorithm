package ga.rugal.tree;

/**
 *
 * @author Rugal Bernstein
 * @param <K>
 * @param <V>
 */
public class TreeNode<K extends Comparable, V> implements Comparable<TreeNode> {

  private K key;

  private V value;

  int height = 0;

  boolean red = true;

  TreeNode<K, V> left;

  TreeNode<K, V> right;

  public TreeNode(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public void setKey(K key) {
    this.key = key;
  }

  public K getKey() {
    return key;
  }

  public V getValue() {
    return value;
  }

  public void setValue(V value) {
    this.value = value;
  }

  @Override
  public int compareTo(TreeNode other) {
    return this.key.compareTo(other.key);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final TreeNode<K, V> other = (TreeNode<K, V>) obj;
    return this.compareTo(other) == 0;
  }

}
