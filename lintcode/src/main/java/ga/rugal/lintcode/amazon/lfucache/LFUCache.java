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
package ga.rugal.lintcode.amazon.lfucache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 *
 * @author rugalbernstein
 */
public class LFUCache {

  private final Map<Integer, CacheNode> cache;

  private final LinkedHashSet[] frequencyList;

  private int lowestFrequency;

  private int maxFrequency;

  private final int maxCacheSize;

  // @param capacity, an integer
  public LFUCache(int capacity) {
    // Write your code here
    this.cache = new HashMap<Integer, CacheNode>(capacity);
    this.frequencyList = new LinkedHashSet[capacity * 2];
    this.lowestFrequency = 0;
    this.maxFrequency = capacity * 2 - 1;
    this.maxCacheSize = capacity;
    initFrequencyList();
  }

  // @param key, an integer
  // @param value, an integer
  // @return nothing
  public void set(int key, int value) {
    // Write your code here
    CacheNode currentNode = cache.get(key);
    if (currentNode == null) {
      if (cache.size() == maxCacheSize) {
        doEviction();
      }
      LinkedHashSet<CacheNode> nodes = frequencyList[0];
      currentNode = new CacheNode(key, value, 0);
      nodes.add(currentNode);
      cache.put(key, currentNode);
      lowestFrequency = 0;
    } else {
      currentNode.v = value;
    }
    addFrequency(currentNode);
  }

  public int get(int key) {
    // Write your code here
    CacheNode currentNode = cache.get(key);
    if (currentNode != null) {
      addFrequency(currentNode);
      return currentNode.v;
    } else {
      return -1;
    }
  }

  public void addFrequency(CacheNode currentNode) {
    int currentFrequency = currentNode.frequency;
    if (currentFrequency < maxFrequency) {
      int nextFrequency = currentFrequency + 1;
      LinkedHashSet<CacheNode> currentNodes = frequencyList[currentFrequency];
      LinkedHashSet<CacheNode> newNodes = frequencyList[nextFrequency];
      moveToNextFrequency(currentNode, nextFrequency, currentNodes, newNodes);
      cache.put(currentNode.k, currentNode);
      if (lowestFrequency == currentFrequency && currentNodes.isEmpty()) {
        lowestFrequency = nextFrequency;
      }
    } else {
      // Hybrid with LRU: put most recently accessed ahead of others:
      LinkedHashSet<CacheNode> nodes = frequencyList[currentFrequency];
      nodes.remove(currentNode);
      nodes.add(currentNode);
    }
  }

  public int remove(int key) {
    CacheNode currentNode = cache.remove(key);
    if (currentNode != null) {
      LinkedHashSet<CacheNode> nodes = frequencyList[currentNode.frequency];
      nodes.remove(currentNode);
      if (lowestFrequency == currentNode.frequency) {
        findNextLowestFrequency();
      }
      return currentNode.v;
    } else {
      return -1;
    }
  }

  public int frequencyOf(int key) {
    CacheNode node = cache.get(key);
    if (node != null) {
      return node.frequency + 1;
    } else {
      return 0;
    }
  }

  public void clear() {
    for (int i = 0; i <= maxFrequency; i++) {
      frequencyList[i].clear();
    }
    cache.clear();
    lowestFrequency = 0;
  }

  public int size() {
    return cache.size();
  }

  public boolean isEmpty() {
    return this.cache.isEmpty();
  }

  public boolean containsKey(int key) {
    return this.cache.containsKey(key);
  }

  private void initFrequencyList() {
    for (int i = 0; i <= maxFrequency; i++) {
      frequencyList[i] = new LinkedHashSet<CacheNode>();
    }
  }

  private void doEviction() {
    int currentlyDeleted = 0;
    double target = 1; // just one
    while (currentlyDeleted < target) {
      LinkedHashSet<CacheNode> nodes = frequencyList[lowestFrequency];
      if (nodes.isEmpty()) {
        break;
      } else {
        Iterator<CacheNode> it = nodes.iterator();
        while (it.hasNext() && currentlyDeleted++ < target) {
          CacheNode node = it.next();
          it.remove();
          cache.remove(node.k);
        }
        if (!it.hasNext()) {
          findNextLowestFrequency();
        }
      }
    }
  }

  private void moveToNextFrequency(CacheNode currentNode, int nextFrequency,
                                   LinkedHashSet<CacheNode> currentNodes,
                                   LinkedHashSet<CacheNode> newNodes) {
    currentNodes.remove(currentNode);
    newNodes.add(currentNode);
    currentNode.frequency = nextFrequency;
  }

  private void findNextLowestFrequency() {
    while (lowestFrequency <= maxFrequency && frequencyList[lowestFrequency].isEmpty()) {
      lowestFrequency++;
    }
    if (lowestFrequency > maxFrequency) {
      lowestFrequency = 0;
    }
  }

  private class CacheNode {

    public final int k;

    public int v;

    public int frequency;

    public CacheNode(int k, int v, int frequency) {
      this.k = k;
      this.v = v;
      this.frequency = frequency;
    }
  }
}
