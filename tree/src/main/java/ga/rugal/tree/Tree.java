package ga.rugal.tree;

/**
 *
 * @author Rugal Bernstein
 * @param <K> type of key
 * @param <V> type of value
 */
public interface Tree<K extends Comparable, V> {

  /**
   * Insert a key-value pair into the tree.<BR>
   * Will override existing tree node if collision happens.
   *
   * @param key
   * @param value
   */
  public void put(K key, V value);

  /**
   * Get corresponding value by given key.
   *
   * @param key
   *
   * @return The corresponding value of tree node by key; Or null if not found in the structure.
   */
  public V get(K key);

  /**
   * Remove a node by the given key.
   *
   * @param key
   *
   * @return true if node found in structure; otherwise return false.
   */
  public boolean remove(K key);

  /**
   * Get current size of the structure.
   *
   * @return A number indicating the size of tree.
   */
  public int size();

  /**
   * See if the structure has node.
   *
   * @return true if tree has no data; otherwise return false.
   */
  public boolean isEmpty();

  /**
   * To see if the structure contains target key.
   *
   * @param key
   *
   * @return true if given key does exists; otherwise return false.
   */
  public boolean containsKey(K key);

  /**
   * To clean the whole structure.
   *
   */
  public void clear();
}
