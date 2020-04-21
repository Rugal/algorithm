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

import ga.rugal.leetcode.ListNode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 *
 * @author rugal
 */
public class Solution {

  public ListNode deleteDuplicates(ListNode head) {
    ListNode prev = null;
    ListNode pointer = head;
    while (pointer != null && pointer.next != null) {
      // have different value
      if (pointer.val != pointer.next.val) {
        // just move the prev to current position
        prev = pointer;
        pointer = pointer.next;
        continue;
      }
      final ListNode temp = delete(pointer);
      if (prev != null) {
        prev.next = temp;
      } else {
        head = temp;
      }
      // move pointer to the most recent one
      pointer = temp;
    }
    return head;
  }

  private ListNode delete(ListNode node) {
    while (node != null && node.next != null && node.val == node.next.val) {
      node = node.next;
    }
    return node.next;
  }
}
