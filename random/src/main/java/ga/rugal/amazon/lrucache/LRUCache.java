package ga.rugal.amazon.lrucache;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/lru-cache/
 *
 * @author Rugal Bernstein
 */
public class LRUCache {

  private final int capacity;

  private final Map<Integer, Node> map;

  private final DoubleLinkedList list;

  public LRUCache(final int capacity) {
    this.capacity = capacity;
    this.map = new HashMap<>(capacity);
    this.list = new DoubleLinkedList();
  }

  /**
   * Get value by key if exists, otherwise return -1. Move key to the head.
   *
   * @param key target
   *
   * @return value
   */
  public int get(final int key) {
    // try to find item
    final Node n = this.map.get(key);
    if (null == n) {
      return -1;
    }
    // move this item to head
    this.list.remove(n);
    this.list.addFirst(n);
    return n.value;
  }

  /**
   * Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache.
   * If the number of keys exceeds the capacity from this operation, evict the least recently used
   * key.
   *
   * @param key   key
   * @param value value
   */
  public void put(final int key, final int value) {
    // try to find item
    final Node n = this.map.get(key);
    // update if it does exist
    if (null != n) {
      n.value = value;
      this.list.remove(n);
      this.list.addFirst(n);
      return;
    }
    // move it to head
    this.list.addFirst(new Node(key, value));
    this.map.put(key, this.list.head);
    // remove LRU item
    if (this.list.size > this.capacity) {
      this.map.remove(this.list.removeLast().key);
    }
  }

  class Node {

    private int key;

    private int value;

    private Node next;

    private Node prev;

    public Node(final int key, final int value) {
      this.key = key;
      this.value = value;
    }
  }

  class DoubleLinkedList {

    private Node head;

    private Node tail;

    private int size = 0;

    public boolean isEmpty() {
      return 0 == this.size;
    }

    public void addFirst(final Node n) {
      if (this.isEmpty()) {
        this.head = this.tail = n;
      } else {
        n.next = this.head;
        this.head.prev = n;
        n.prev = null;
        this.head = n;
      }
      ++this.size;
    }

    public void removeFirst() {
      if (this.isEmpty()) {
        return;
      }
      if (1 == this.size) {
        this.head = this.tail = null;
      } else {
        this.head.next.prev = null;
        this.head = this.head.next;
      }
      --this.size;
    }

    public Node removeLast() {
      if (this.isEmpty()) {
        return null;
      }
      final Node n = this.tail;
      if (1 == this.size) {
        this.head = this.tail = null;
      } else {
        this.tail.prev.next = null;
        this.tail = this.tail.prev;
      }
      --this.size;
      return n;
    }

    public void remove(final Node n) {
      if (this.head == n) {
        this.removeFirst();
        return;
      }
      if (this.tail == n) {
        this.removeLast();
        return;
      }
      n.prev.next = n.next;
      n.next.prev = n.prev;
      n.prev = n.next = null;
      --this.size;
    }
  }
}

class LRUCacheQuick {

  private final int capacity;

  private final Map<Integer, Integer> map;

  public LRUCacheQuick(final int capacity) {
    this.capacity = capacity;
    map = new LinkedHashMap<>();
  }

  public int get(final int key) {
    final Integer val = map.get(key);
    if (val == null) {
      return -1;
    }
    map.remove(key);
    map.put(key, val);
    return val;
  }

  public void put(final int key, final int value) {
    map.remove(key);
    map.put(key, value);
    if (map.size() > this.capacity) {
      final Integer k = map.keySet().iterator().next();
      map.remove(k);
    }
  }
}
