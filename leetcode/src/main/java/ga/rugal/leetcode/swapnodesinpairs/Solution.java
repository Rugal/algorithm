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
package ga.rugal.leetcode.swapnodesinpairs;

import ga.rugal.leetcode.ListNode;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 *
 * @author rugalbernstein
 */
public class Solution {

  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    //Given 1->2->3->4, you should return the list as 2->1->4->3.
    ListNode newHead = new ListNode(0); 
    newHead.next = head;

    ListNode current = newHead;//0
    ListNode toBeInsert = current.next.next;//1

    /*
     *     0  ->  2  ->  1  ->  4  ->  3
     *     ^             ^
     *     |             |
     *  current          |
     *                   |
     *                   |
     *               toBeInsert
     */
    while (current != null && toBeInsert != null) {

    /*
     *     0  ->  2  ->  4  ->  3
     *     ^             ^
     *     |             |
     *  current          1
     *                   ^
     *                   |
     *                   |
     *               toBeInsert
     */
      current.next.next = toBeInsert.next;

    /*
     *     0  ->  2  ->  4  ->  3
     *     ^      ^
     *     |      |
     *  current   1
     *            ^
     *            |
     *            |
     *        toBeInsert
     */
      toBeInsert.next = current.next;

    /*
     *     0  ->  1  ->  2  ->  4  ->  3
     *     ^      ^
     *     |      |
     *  current   |
     *            |
     *            |
     *        toBeInsert
     */
      current.next = toBeInsert;

    /*
     *     0  ->  1  ->  2  ->  4  ->  3
     *            ^      ^
     *            |      |
     *            |      current
     *            |
     *            |
     *        toBeInsert
     */
      current = toBeInsert.next;
      if (current.next != null && current.next.next != null) {
        toBeInsert = current.next.next;
      } else {
        current = null;
      }
    }

    return newHead.next;

  }
}
