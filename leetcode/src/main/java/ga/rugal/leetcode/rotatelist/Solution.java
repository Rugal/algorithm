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
package ga.rugal.leetcode.rotatelist;

import ga.rugal.leetcode.ListNode;

/**
 * https://leetcode.com/problems/rotate-list/
 *
 * @author rugal
 */
public class Solution {

  public ListNode rotateRight(final ListNode head, int k) {
    if (null == head) {
      return head;
    }
    int length = 0;
    ListNode originalEnd = head;
    for (ListNode current = head; current != null; current = current.next, ++length) {
      if (current.next != null) {//find the original end node
        originalEnd = originalEnd.next;
      }
    }
    k %= length;//ignore multiple round
    if (k == 0) {//means no change
      return head;
    }
    ListNode newEnd = head;
    //find the new end node
    for (int i = length - k - 1; i > 0; --i, newEnd = newEnd.next);
    final ListNode newHead = newEnd.next;
    originalEnd.next = head;
    newEnd.next = null;
    return newHead;
  }
}
