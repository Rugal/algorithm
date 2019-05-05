/*
 * Copyright 2019 rugal.
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
package ga.rugal.leetcode.designhashmap;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/design-hashmap/
 *
 * @author rugal
 */
public class MyHashMap {

  private boolean[] keys;

  private int[] values;

  /**
   * Initialize your data structure here.
   */
  public MyHashMap() {
    keys = new boolean[100];
    values = new int[100];
  }

  /**
   * value will always be non-negative.
   */
  public void put(int key, int value) {
    if (key >= keys.length) {
      extend(key);
    }
    keys[key] = true;
    values[key] = value;
  }

  /**
   * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping
   * for the key
   */
  public int get(int key) {
    return key >= keys.length || !keys[key] ? -1 : values[key];
  }

  /**
   * Removes the mapping of the specified value key if this map contains a mapping for the key
   */
  public void remove(int key) {
    if (key < keys.length) {
      keys[key] = false;
    }
  }

  private void extend(int key) {
    keys = Arrays.copyOf(keys, key + 1);
    values = Arrays.copyOf(values, key + 1);
  }
}
