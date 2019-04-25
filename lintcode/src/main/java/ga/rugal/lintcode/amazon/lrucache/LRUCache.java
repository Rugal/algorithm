/*
 * Copyright 2019 rugalbernstein.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ga.rugal.lintcode.amazon.lrucache;

import java.util.HashMap;

/**
 * https://www.lintcode.com/problem/lru-cache
 *
 * @author rugalbernstein
 */
public class LRUCache {

  private class Node {

    Node prev;

    Node next;

    int key;

    int value;

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
      this.prev = null;
      this.next = null;
    }
  }

  private int capacity;

  private HashMap<Integer, Node> hs = new HashMap<>();

  private Node head = new Node(-1, -1);

  private Node tail = new Node(-1, -1);

  public LRUCache(int capacity) {
    this.capacity = capacity;
    tail.prev = head;
    head.next = tail;
  }

  public int get(int key) {
    if (!hs.containsKey(key)) {    		//key找不到
      return -1;
    }

    // remove current
    Node current = hs.get(key);
    current.prev.next = current.next;
    current.next.prev = current.prev;

    // move current to tail
    move_to_tail(current);			//每次get，使用次数+1，最近使用，放于尾部

    return hs.get(key).value;
  }

  public void set(int key, int value) {			//数据放入缓存
    // get 这个方法会把key挪到最末端，因此，不需要再调用 move_to_tail
    if (get(key) != -1) {
      hs.get(key).value = value;
      return;
    }

    if (hs.size() == capacity) {		//超出缓存上限
      hs.remove(head.next.key);		//删除头部数据
      head.next = head.next.next;
      head.next.prev = head;
    }

    Node insert = new Node(key, value);		//新建节点
    hs.put(key, insert);
    move_to_tail(insert);					//放于尾部
  }

  private void move_to_tail(Node current) {    //移动数据至尾部
    current.prev = tail.prev;
    tail.prev = current;
    current.prev.next = current;
    current.next = tail;
  }
}
