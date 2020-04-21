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
package ga.rugal.leetcode.removeduplicatesfromsortedlist;

import ga.rugal.leetcode.ListNode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 *
 * @author rugal
 */
public class Solution {

  public ListNode deleteDuplicates(ListNode head) {
    if (head != null) {
      for (ListNode current = head; current.next != null;) {
        if (current.val == current.next.val) {
          // will not move, but skip the next node
          current.next = current.next.next;
        } else {
          // move only if duplicated
          current = current.next;
        }
      }
    }
    return head;
  }
}
