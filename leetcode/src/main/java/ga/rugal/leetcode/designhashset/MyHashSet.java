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
package ga.rugal.leetcode.designhashset;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/design-hashset
 *
 * @author rugal
 */
public class MyHashSet {

  boolean[] arr = new boolean[100];// start with 100 elements for fast initialization

  /**
   * Initialize your data structure here.
   */
  public MyHashSet() {

  }

  public void add(int key) {
    if (key >= arr.length) // if array is too small to accomodate key, extend it.
    {
      extend(key);
    }
    arr[key] = true;
  }

  public void remove(int key) {
    if (key >= arr.length) // if array is too small to accomodate key, extend it.
    {
      extend(key);
    }
    arr[key] = false;
  }

  /**
   * Returns true if this set contains the specified element
   */
  public boolean contains(int key) {
    if (key >= arr.length) // key cannot be in array if array's length < key
    {
      return false;
    }
    return arr[key] == true;
  }

  public void extend(int key) {
    arr = Arrays.copyOf(arr, key + 2);  // extend array to one more item than necessary, we need "key" items.
    // we give "key+1" items to reduce collisions.
  }
}
