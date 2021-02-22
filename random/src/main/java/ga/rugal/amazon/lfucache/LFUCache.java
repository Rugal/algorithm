package ga.rugal.amazon.lfucache;

import java.util.HashMap;

public class LFUCache {
  private final HashMap<Integer, KeyNode> map;
  private int size;
  private final int capacity;
  private final FreqNode start;
  private final FreqNode end;

  public LFUCache(int capacity) {
    this.capacity = capacity;
    this.size = 0;
    map = new HashMap<>();
    start = new FreqNode(0);
    end = new FreqNode(Integer.MAX_VALUE);
    start.next = end;
  }

  public int get(int key) {

    if (capacity == 0) {
      return -1;
    }
    if (!map.containsKey(key)) {
      return -1;
    }
    KeyNode curr = map.get(key);
    updateFreq(curr);
    return curr.val;
  }

  public void put(int key, int value) {

    if (capacity == 0) {
      return;
    }

    KeyNode curr = null;

    if (map.containsKey(key)) {
      curr = map.get(key);
      curr.val = value;
    } else if (size < capacity) {
      curr = new KeyNode(key, value, start);
      start.add(curr);
      ++size;
    } else {
      curr = new KeyNode(key, value, start);
      start.add(curr);
      FreqNode removeParent = start.next;
      map.remove(removeParent.end.prev.key);
      removeParent.end.prev = removeParent.end.prev.prev;
      removeParent.end.prev.next = removeParent.end;
    }

    map.put(key, curr);
    updateFreq(curr);
  }

  private void updateFreq(KeyNode node) {

    FreqNode parent = node.parent;

    if (parent.next.freq > parent.freq + 1) {
      FreqNode nextParent = new FreqNode(parent.freq + 1);
      nextParent.next = parent.next;
      parent.next = nextParent;
      nextParent.prev = parent;
      nextParent.next.prev = nextParent;
    }

    parent.remove(node);
    parent.next.add(node);
    node.parent = parent.next;

    //removes parent from freq buckets
    if (parent != start && parent != end && parent.isEmpty()) {
      parent.next.prev = parent.prev;
      parent.prev.next = parent.next;
    }
  }

  class KeyNode {
    int val, key;
    KeyNode next, prev;
    FreqNode parent;

    public KeyNode(int key, int val, FreqNode parent) {
      this.key = key;
      this.val = val;
      this.parent = parent;
    }
  }

  class FreqNode {
    int freq;
    KeyNode start, end;
    FreqNode next, prev;

    public FreqNode(int freq) {
      this.freq = freq;
      this.start = new KeyNode(-1, -1, null);
      this.end = new KeyNode(-1, -1, null);
      this.start.next = end;
      this.end.prev = start;
    }

    public void add(KeyNode node) {
      KeyNode head = this.start.next;
      head.prev = node;
      node.next = head;

      start.next = node;
      node.prev = start;
    }

    public void remove(KeyNode node) {
      if (isEmpty()) {
        return;
      }
      node.prev.next = node.next;
      node.next.prev = node.prev;
    }

    public boolean isEmpty() {
      return start.next == end;
    }
  }
}
