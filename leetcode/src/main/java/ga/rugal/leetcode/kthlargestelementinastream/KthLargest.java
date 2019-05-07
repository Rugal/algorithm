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
package ga.rugal.leetcode.kthlargestelementinastream;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 *
 * @author rugal
 */
public class KthLargest {

  private final PriorityQueue<Integer> queue;

  private final int cap;

  public KthLargest(int k, int[] nums) {
    cap = k;
    queue = new PriorityQueue<>();
    for (int i : nums) {
      queue.offer(i);
      if (queue.size() > k) {
        queue.poll();
      }
    }
  }

  public int add(int val) {
    queue.offer(val);
    if (queue.size() > cap) {
      queue.poll();
    }
    return queue.peek();
  }
}
