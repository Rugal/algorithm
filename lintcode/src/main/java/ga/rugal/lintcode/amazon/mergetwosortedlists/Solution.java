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
package ga.rugal.lintcode.amazon.mergetwosortedlists;

import ga.rugal.lintcode.ListNode;

/**
 * https://www.lintcode.com/problem/merge-two-sorted-lists/description
 *
 * @author rugal
 */
public class Solution {

  /**
   * @param l1: ListNode l1 is the head of the linked list
   * @param l2: ListNode l2 is the head of the linked list
   *
   * @return ListNode head of linked list
   */
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    // write your code here
    final ListNode head = new ListNode(0);
    ListNode current = head;
    for (; l1 != null && l2 != null;) {
      if (l1.val <= l2.val) {
        current.next = l1;
        l1 = l1.next;
      } else {
        current.next = l2;
        l2 = l2.next;
      }
      current = current.next;
    }
    if (l1 != null || l2 != null) {
      current.next = l1 != null ? l1 : l2;
    }
    return head.next;
  }
}
