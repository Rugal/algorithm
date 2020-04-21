/*
 * Copyright 2020 rugal.
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
package ga.rugal.leetcode.removeduplicatesfromsortedlistii;

import java.util.HashMap;
import java.util.Map;

import ga.rugal.leetcode.ListNode;

/**
 *
 * @author rugal
 */
public class Solution {

  public ListNode deleteDuplicates(final ListNode head) {
    if (null == head) {
      return null;
    }
    final Map<Integer, Integer> map = new HashMap<>();
    for (ListNode n = head; n != null; n = n.next) {
      final int value = map.getOrDefault(n.val, 0);
      map.put(n.val, value + 1);
    }
    final ListNode fakeHead = new ListNode(Integer.MAX_VALUE);
    fakeHead.next = head;

    for (ListNode n = head, p = fakeHead; n != null && n.next != null;) {
      final int count = map.get(n.val);
      // unique value
      if (count == 1) {
        n = n.next;
        p = p.next;
        continue;
      }
      // remove duplicated value
      for (int i = 0; i < count; ++i) {
        n = n.next;
      }
      p.next = n;
    }
    return fakeHead.next;
  }
}
