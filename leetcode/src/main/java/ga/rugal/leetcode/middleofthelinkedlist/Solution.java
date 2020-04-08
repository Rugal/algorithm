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
package ga.rugal.leetcode.middleofthelinkedlist;

import ga.rugal.leetcode.ListNode;

/**
 * https://leetcode.com/problems/middle-of-the-linked-list/
 *
 * @author rugal
 */
public class Solution {

  public ListNode middleNode(final ListNode head) {
    ListNode slow = head;
    for (ListNode fast = head;
         fast != null && fast.next != null;
         slow = slow.next, fast = fast.next.next);
    return slow;
  }
}
